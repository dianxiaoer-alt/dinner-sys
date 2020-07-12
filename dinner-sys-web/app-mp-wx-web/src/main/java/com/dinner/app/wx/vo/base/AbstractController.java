package com.dinner.app.wx.vo.base;

import com.dinner.app.wx.config.jasypt.JasyptConfig;
import com.dinner.app.wx.feignService.ShopFeign;
import com.dinner.app.wx.feignService.UserFeign;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.domain.User;
import com.dinner.commons.utils.HttpContextUtils;
import com.dinner.commons.utils.IPUtils;
import com.dinner.wx.pay.constants.WXPayConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：初始化配置
 *
 * @author:陈丽强
 * @Date:2020/5/23 19:45
 */
@Component
public class AbstractController {

    @Autowired
    private ShopFeign shopFeign;
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private JasyptConfig jasyptConfig;




    private HttpServletRequest request =  HttpContextUtils.getHttpServletRequest();

    protected Long shop_id = Long.parseLong(request.getParameter("shop_id")) ;

    protected Long user_id =Long.parseLong( request.getParameter("user_id"));





    /**
     * shop 商家
     */
    protected Shop shop = shopFeign.queryOneById(Long.valueOf(shop_id)).getData();

    /**
     * 在线的用户
     */
    protected User user = userFeign.queryById(Long.valueOf(user_id)).getData();
    /**
     * 请求ip
     */
    protected String ip = IPUtils.getIpAddr(request);


    /**
     * 初始化配置信息
     */
    protected void init(){
        if (shop == null)
            throw new RuntimeException("商户号等信息初始化失败");




    }
}
