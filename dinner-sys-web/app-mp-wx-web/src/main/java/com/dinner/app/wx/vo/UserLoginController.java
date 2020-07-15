package com.dinner.app.wx.vo;

import com.dinner.app.wx.config.jasypt.JasyptConfig;
import com.dinner.app.wx.vo.base.AbstractController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/23 20:03
 */
@RestController
@RequestMapping("userLogin")
public class UserLoginController{

    @Autowired
    private JasyptConfig jasyptConfig;



    /**
     *  获取用户code
     * @return
     */
    @RequestMapping("getCode")
    public String toGetCode(){
       /* if(shop != null){
            String url  = "https://open.weixin.qq.com/connect/oauth2/authorize";
            String res_html = "http%3a%2f%2fsmall.nat300.top%2forder-shop-mobile%2flogin.html";
            String res = "redirect:"+url+"?appid="+jasyptConfig.decyptPwd(shop.getApp_id())+"&redirect_uri="+res_html+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
            return res;
        }*/
        return "Error";
    }
}
