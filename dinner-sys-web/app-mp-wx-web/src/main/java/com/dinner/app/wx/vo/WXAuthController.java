package com.dinner.app.wx.vo;



import com.dinner.app.wx.ao.WXAuthAO;
import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.vo.base.AbstractController;
import com.dinner.commons.domain.User;
import com.dinner.commons.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Api(tags = "微信签名")
@Controller
@RequestMapping("weixin/auth")
@Slf4j
public class WXAuthController{
    @Autowired
    private WXAuthAO wxAuthAO;
    /**
     * 获取code之后进行获取openid
     * @param code
     * @return
     */
    @ApiOperation("用户换取openid与access_token")
    @UserPassToken
    @ResponseBody
    @GetMapping(value="authorize")
    public Result<Map<String,Object>> authorize(String code, HttpServletRequest request){
        Long shop_id = Long.parseLong(request.getHeader("shopId"));
        return wxAuthAO.authorize(code,shop_id);
    }

    @ApiOperation("用户刷新续期openid与access_token,很少用")
    @UserPassToken
    @ResponseBody
    @GetMapping(value="reflushAccessToken")
    public Result<Map<String,Object>> reflushAccessToken(String refresh_token,Long shop_id){
        return wxAuthAO.reflushAccessToken(refresh_token,shop_id);
    }
    @UserPassToken
    @ResponseBody
    @GetMapping("login")
    public Result<String> login(String access_token, String open_id, HttpServletRequest request) {
        Long shop_id = Long.parseLong(request.getHeader("shopId"));
        return wxAuthAO.login(access_token,open_id,shop_id);
    }

    //扫码登陆入口
    @UserPassToken
    @GetMapping("getCode")
    public String getCode(Long shopId){
        log.info(wxAuthAO.getCode(shopId));
        return wxAuthAO.getCode(shopId);
    }

    /**
     * 公众号测试账号
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @ResponseBody
    @ApiOperation("用户换取token")
    @GetMapping(value="token")
    public Object getToken(String signature,String timestamp,String nonce,String echostr){
        //1. 将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = {timestamp,nonce,"smjkt"}; //后面为token页面填写的
        Arrays.sort(arr);
        //2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for (String temp : arr) {
            sb.append(temp);
        }
        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if(sb.toString().equals(signature)){
            //接入成功
            return Result.success(echostr);
        }
        return echostr;
    }

}
