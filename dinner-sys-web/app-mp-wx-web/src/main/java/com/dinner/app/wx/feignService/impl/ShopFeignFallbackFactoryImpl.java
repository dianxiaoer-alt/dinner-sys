package com.dinner.app.wx.feignService.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feignService.ShopFeignService;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service("ShopFeignService")
public class ShopFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<ShopFeignService> {
    @Override
    public ShopFeignService create(Throwable throwable) {
        return new ShopFeignService() {
            @Override
            public Result<Shop> queryOneById(Long shopId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
