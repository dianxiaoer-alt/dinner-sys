package com.dinner.app.wx.ao.impl;

import com.dinner.app.wx.ao.UserPayOrderAO;
import com.dinner.app.wx.config.jasypt.JasyptConfig;
import com.dinner.app.wx.feign.GoodsOrderFeignAO;
import com.dinner.app.wx.feign.ShopFeignAO;
import com.dinner.app.wx.feign.UserFeignAO;
import com.dinner.app.wx.pojo.request.UnifiedOrderReq;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.domain.User;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.ShopDTO;
import com.dinner.wx.pay.WXPay;
import com.dinner.wx.pay.WXPayConfigImpl;
import com.dinner.wx.pay.constants.WXPayRequestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Slf4j
@Service
public class UserPayOrderAOImpl implements UserPayOrderAO {

    @Autowired
    private ShopFeignAO shopFeignAO;
    @Autowired
    private UserFeignAO userFeignAO;
    @Autowired
    private GoodsOrderFeignAO orderFeignAO;

    @Autowired
    private JasyptConfig jasyptConfig;

    String notify_url = "http://dinner-sys.natapp1.cc/wx/pay/notify";

    @Override
    public synchronized Result<Map<String, String>> unifiedOrder(UnifiedOrderReq req) {
        try {
            Result<ShopDTO> shopRes = shopFeignAO.queryDetailById(req.getShopId());
            if (shopRes == null || shopRes.getData() == null)
                throw new RuntimeException("商家不存在");

            Result<User> userRes = userFeignAO.queryById(req.getUserId());
            if (userRes == null || userRes.getData() == null)
                throw new RuntimeException("用户不存在");

            Result<GoodsOrder> orderRes = orderFeignAO.queryById(req.getOrderId());
            if (orderRes == null || orderRes.getData() == null)
                throw new RuntimeException("订单不存在");

            ShopDTO shop = shopRes.getData();
            User user = userRes.getData();
            GoodsOrder order = orderRes.getData();

            WXPayRequestConfig requestConfig = new WXPayRequestConfig();
            requestConfig.setAPP_ID(jasyptConfig.decyptPwd(shop.getApp_id()));
            requestConfig.setAPI_KEY(jasyptConfig.decyptPwd(shop.getPay_key()));
            requestConfig.setMCH_ID(jasyptConfig.decyptPwd(shop.getMch_id()));
            requestConfig.setSECRET(jasyptConfig.decyptPwd(shop.getApp_secret()));

            WXPayConfigImpl wxPayConfig = new WXPayConfigImpl(requestConfig);
            WXPay wxPay = new WXPay(requestConfig,wxPayConfig);

            long currentTime = System.currentTimeMillis();
            Date startTime = new Date(currentTime);
            Date endTime = new Date(currentTime+30*1000*60);

            Map<String,String> resultMap = wxPay.unifiedOrder(notify_url,user.getOpen_id(),req.getBody(),order.getOrder_num(),
                    String.valueOf(order.getOrder_price()),req.getIp(),null,req.getDesc(),startTime,endTime);
            log.info(String.valueOf(resultMap));
            if (resultMap.get("return_code").equals("SUCCESS")){
                String prepay_id = resultMap.get("prepay_id");
                String nonce_str = resultMap.get("nonce_str");
                Map<String, String> map = wxPay.chooseWXPayMap(prepay_id, nonce_str);
                return Result.success(map);
            }else{
                return Result.error(1,"下单失败,请注意配置是否有误！");
            }

        }catch (Exception e){
            log.error(String.valueOf(e));
            e.printStackTrace();
        }

        return Result.error(1,"下单失败");
    }
}
