package com.dinner.app.wx.ao.impl;



import com.alibaba.fastjson.JSONObject;
import com.dinner.app.wx.ao.WXAuthAO;
import com.dinner.app.wx.config.jasypt.JasyptConfig;
import com.dinner.app.wx.config.jwt.JWTTokenConfig;
import com.dinner.app.wx.feign.ShopFeignAO;
import com.dinner.app.wx.feign.UserFeignAO;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.domain.User;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.ShopDTO;
import com.dinner.wx.pay.constants.WXConstants;
import com.dinner.wx.pay.constants.WXPayConstants;
import com.dinner.wx.pay.constants.WXPayRequestConfig;
import com.dinner.wx.pay.utils.WXUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@Slf4j
public class WXAuthAOImpl implements WXAuthAO {
    //http://dinner-sys.natapp1.cc/views/login.html
    private String resUrl = "http%3A%2F%2Fdinner-sys.natapp1.cc%2Fviews%2Flogin.html";

    private String url  = WXPayConstants.AUTHORIZE_URL;

    @Autowired
    private ShopFeignAO shopFeignAO;
    @Autowired
    private UserFeignAO userFeignAO;
    @Autowired
    private JasyptConfig jasyptConfig;
    @Autowired
    private JWTTokenConfig jwtTokenConfig;


    @Override
    public Result<Map<String, Object>> authorize(String code,Long shop_id) {
        Result<Map<String, Object>> resp = new Result<>();
        try {
            Result<ShopDTO> res =  shopFeignAO.queryDetailById(shop_id);
            if (res.getData() == null){
                return Result.error(1,"该商家不存在");
            }
            ShopDTO shop = res.getData();
            WXUtils wxUtils = new WXUtils(initWXPay(shop));
            if(StringUtils.isNoneBlank(code)){
                Map<String, Object> map = wxUtils.getJsapiAccessTokenByCode(code);
                resp =  Result.success(map);
            }else{
                resp = Result.error(1,"code不能为空");
            }
        }catch (Exception e){
            resp = Result.error(1,e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<String> login(String access_token, String open_id,Long shop_id) {
        Result<String> res = new Result<>();
        try {
            log.info("参数access_token = "+access_token+"'----------open_id="+open_id);
            Result<ShopDTO> resShop =  shopFeignAO.queryDetailById(shop_id);
            if (res.getData() == null){
                return Result.error(1,"该商家不存在");
            }
            ShopDTO shop = resShop.getData();
            WXUtils wxUtils = new WXUtils(initWXPay(shop));
            // 通过access_token和openid请求获取用户信息
            JSONObject jsonUserinfo = wxUtils.getJsapiUserinfo(access_token, open_id);
            if (null == jsonUserinfo) {
                return Result.error(1, WXConstants.ERROR);
            }
           User resUser = null;
           Result<User> user = userFeignAO.queryOneByOpenId(open_id);

            if(user == null){
                User us = new User();
                us.setAccess_token(access_token);
                us.setHead_img_url(jsonUserinfo.getString("headimgurl"));
                us.setNick_name(jsonUserinfo.getString("nickname"));
                us.setOpen_id(open_id);
                us.setProfile(jsonUserinfo.toString());
                UserReq userReq = new UserReq();
                BeanUtils.copyProperties(us,userReq);
                userFeignAO.save(userReq);
               resUser = us;
            }else{
                resUser = user.getData();
            }


            if (resUser != null)
                return Result.success(jwtTokenConfig.getTokenString(resUser));


        }catch (Exception e){
            res = Result.error(1,e.getMessage());
        }

        return res;
    }

    @Override
    public Result<Map<String, Object>> reflushAccessToken(String access_token,Long shop_id) {
        Result<Map<String, Object>> resp = new Result<>();
        try {
            if (shop_id == null || StringUtils.isBlank(access_token))
                return Result.error(1,"shopId或access_token不能为空");
            Result<ShopDTO> res =  shopFeignAO.queryDetailById(shop_id);
            if (res.getData() == null){
                return Result.error(1,"该商家不存在");
            }
            ShopDTO shop = res.getData();
            WXUtils wxUtils = new WXUtils(initWXPay(shop));
            if(StringUtils.isNoneBlank(access_token)){
                Map<String, Object> map = wxUtils.refushAccessToken(access_token);
                resp =  Result.success(map);
            }else{
                resp = Result.error(1,"access_token不能为空");
            }
        }catch (Exception e){
            resp = Result.error(1,e.getMessage());
        }

        return resp;
    }

    @Override
    public String getCode(Long shopId) {
        if (shopId == null)
            return null;
        Result<ShopDTO> res =  shopFeignAO.queryDetailById(shopId);
        if (res.getCode() !=0)
            return null;

        return "redirect:"+url+"?appid="+jasyptConfig.decyptPwd(res.getData().getApp_id())+"&redirect_uri="+resUrl+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }

    private WXPayRequestConfig initWXPay(ShopDTO shop){
        if (shop == null)
            return null;
        WXPayRequestConfig requestConfig = new WXPayRequestConfig();
        requestConfig.setAPP_ID(jasyptConfig.decyptPwd(shop.getApp_id()));
        requestConfig.setAPI_KEY(jasyptConfig.decyptPwd(shop.getPay_key()));
        requestConfig.setMCH_ID(jasyptConfig.decyptPwd(shop.getMch_id()));
        requestConfig.setSECRET(jasyptConfig.decyptPwd(shop.getApp_secret()));
        return requestConfig;
    }
}
