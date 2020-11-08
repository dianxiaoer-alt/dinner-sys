package com.dinner.shop.admin.feign;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.feign.impl.UserOrderFeignFallbackFactory;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "order",fallbackFactory = UserOrderFeignFallbackFactory.class)
public interface UserOrderFeign {

    @PostMapping(value = "order/queryList")
    Result<List<GoodsOrder>> queryList(@RequestBody GoodsOrderQuery query);

    @PostMapping(value = "order/queryPage")
    PageResult<GoodsOrder> queryPage(@RequestBody  GoodsOrderQuery query);

    @GetMapping(value = "order/queryById")
    Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId);

    @GetMapping(value = "orderDetail/queryById")
    Result<OrderDetail> queryOrderDetailById(@RequestParam("orderDetailId")Long orderDetailId);
}
