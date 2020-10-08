package com.dinner.app.wx.vo.base;

import com.dinner.commons.utils.HttpContextUtils;
import com.dinner.commons.utils.IPUtils;

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
