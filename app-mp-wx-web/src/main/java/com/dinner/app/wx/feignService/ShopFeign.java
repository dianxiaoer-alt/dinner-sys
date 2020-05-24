package com.dinner.app.wx.feignService;

import com.dinner.app.wx.feignService.impl.ShopFeignFallbackFactoryImpl;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop",fallbackFactory = ShopFeignFallbackFactoryImpl.class)
public interface ShopFeign {

    @GetMapping("shop/queryById")
    Result<Shop> queryOneById(@RequestParam("shopId") Long shopId);
}
