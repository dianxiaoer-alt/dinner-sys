package com.dinner.app.wx.vo.base;

import com.dinner.app.wx.config.jasypt.JasyptConfig;
import com.dinner.app.wx.feignService.ShopFeignService;
import com.dinner.app.wx.feignService.UserFeignService;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.domain.User;
import com.dinner.commons.utils.HttpContextUtils;
import com.dinner.commons.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：初始化配置
 *
 * @author:陈丽强
 * @Date:2020/5/23 19:45
 */

public class AbstractController {

    private HttpServletRequest request =  HttpContextUtils.getHttpServletRequest();

    protected Long shop_id = Long.parseLong(request.getParameter("shop_id")) ;

    protected Long user_id =Long.parseLong( request.getParameter("user_id"));





    /**
     * 请求ip
     */
    protected String ip = IPUtils.getIpAddr(request);

}
