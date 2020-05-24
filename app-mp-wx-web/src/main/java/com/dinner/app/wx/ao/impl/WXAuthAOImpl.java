package com.dinner.app.wx.ao.impl;



import com.dinner.app.wx.ao.WXAuthAO;
import com.dinner.commons.domain.User;
import com.dinner.commons.result.Result;
import com.dinner.wx.pay.utils.WXUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service("WXAuthAO")
@Slf4j
public class WXAuthAOImpl implements WXAuthAO {
    @Autowired
    private WXUtils wxUtils ;

    @Override
    public Result<Map<String, Object>> authorize(String code) {
        Result<Map<String, Object>> resp = new Result<>();
        try {
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
    public Result<User> userInfo(String access_token, String open_id, HttpSession session) {
     /*   Result<User> res = new Result<User>();
        try {
            log.info("参数access_token = "+access_token+"'----------open_id="+open_id);
            // 通过access_token和openid请求获取用户信息
            JSONObject jsonUserinfo = wxUtils.getJsapiUserinfo(access_token, open_id);
            if (null == jsonUserinfo) {
                return Result.error(1, WXConstants.ERROR);
            }



            User resUser = null;
           User user = userManager.queryOneByOpenId(open_id);

            if(user == null){
                User us = new User();
                us.setAccess_token(access_token);
                us.setHead_img_url(jsonUserinfo.getString("headimgurl"));
                us.setNick_name(jsonUserinfo.getString("nickname"));
                us.setOpen_id(open_id);
                us.setProfile(jsonUserinfo.toString());
                userManager.insertUser(us);
               resUser = us;
            }else{
                resUser = user;
            }


            //登录成功
            session.setMaxInactiveInterval(-1);
            session.setAttribute(SessionConfig.USER,resUser.getId());
            return Result.success(resUser);
        }catch (Exception e){
            res = Result.error(1,e.getMessage());
        }*/

        return null;
    }

    @Override
    public Result<Map<String, Object>> reflushAccessToken(String access_token) {
        Result<Map<String, Object>> resp = new Result<>();
        try {
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
}
