package com.dinner.app.wx.feignService.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feignService.ShopFeign;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service("ShopFeign")
public class ShopFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<ShopFeign> {
    @Override
    public ShopFeign create(Throwable throwable) {
        return new ShopFeign() {
            @Override
            public Result<Shop> queryOneById(Long shopId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
