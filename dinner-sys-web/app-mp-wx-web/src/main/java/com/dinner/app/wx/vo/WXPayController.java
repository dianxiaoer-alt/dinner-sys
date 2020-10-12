package com.dinner.app.wx.vo;

import com.dinner.app.wx.ao.UserPayOrderAO;
import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.pojo.request.UnifiedOrderReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RequestMapping("wx/pay")
@RestController
public class WXPayController {

    @Autowired
    private UserPayOrderAO userPayOrderAO;

    //支付订单
    @UserPassToken
    @PostMapping("unifiedOrder")
    public Result<Map<String, String>> unifiedOrder(@Valid @RequestBody UnifiedOrderReq req, HttpServletRequest request){
        req.setShopId(Long.parseLong(request.getHeader("shopId")));
        req.setUserId(Long.parseLong(String.valueOf(request.getAttribute("userId"))));
        req.setIp(IPUtils.getIpAddr(request));
        return userPayOrderAO.unifiedOrder(req);
    }

    @UserPassToken
    @RequestMapping("notify")
    public void notify(HttpServletRequest request){

    }
}
