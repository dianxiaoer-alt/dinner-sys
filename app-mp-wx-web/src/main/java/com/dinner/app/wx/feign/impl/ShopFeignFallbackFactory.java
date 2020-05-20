package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.ShopFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
public class ShopFeignFallbackFactory extends AbstractFallbackFactory implements FallbackFactory<ShopFeign> {
    @Override
    public ShopFeign create(Throwable throwable) {
        return new ShopFeign() {
        };
    }
}
