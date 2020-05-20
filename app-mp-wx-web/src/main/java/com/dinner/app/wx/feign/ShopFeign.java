package com.dinner.app.wx.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("shop")
public interface ShopFeign {

}
