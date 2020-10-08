package com.dinner.order.feign;

import com.dinner.commons.domain.Shop;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("shop")
public interface ShopFeign {

    @GetMapping(value = "shop/queryById")
    Result<Shop> queryById(@RequestParam("shopId") Long shopId);
}
