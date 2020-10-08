package com.dinner.app.wx.vo;
import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.feign.GoodsOrderFeignAO;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("order")
public class GoodsOrderController {

    @Autowired
    private GoodsOrderFeignAO goodsOrderFeignAO;

    @UserPassToken
    @GetMapping("saveByCollectIds")
    public Result<Integer> saveByCollectIds(@RequestParam("goodsCollectIds")String goodsCollectIds, HttpServletRequest request){
       Long shopId =  Long.parseLong(request.getHeader("shopId"));
       Long userId =  Long.parseLong(String.valueOf(request.getAttribute("userId")));
      return goodsOrderFeignAO.saveByCollectIds(goodsCollectIds,shopId,userId);
    }
    @UserPassToken
    @RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return goodsOrderFeignAO.queryById(goodsOrderId);
    }
}
