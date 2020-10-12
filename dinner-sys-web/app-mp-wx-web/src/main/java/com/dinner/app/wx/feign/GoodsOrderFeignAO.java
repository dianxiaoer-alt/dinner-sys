package com.dinner.app.wx.feign;

import com.dinner.app.wx.feign.impl.GoodsCollectFeignFallbackImpl;
import com.dinner.app.wx.feign.impl.GoodsOrderFeignFallbackImpl;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="order",fallbackFactory = GoodsOrderFeignFallbackImpl.class)
public interface GoodsOrderFeignAO {

   @GetMapping("order/saveByCollectIds")
   Result<Integer> saveByCollectIds(@RequestParam("goodsCollectIds")String goodsCollectIds, @RequestParam("shopId")Long shopId, @RequestParam("userId")Long userId);

    @GetMapping(value = "order/queryById")
    Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId);

    @PostMapping(value = "order/queryList")
    Result<List<GoodsOrder>> queryList(@RequestBody GoodsOrderQuery query);

    @PostMapping(value = "order/update")
    Result<Integer> update(@RequestBody GoodsOrderReq goodsOrderReq);
}
