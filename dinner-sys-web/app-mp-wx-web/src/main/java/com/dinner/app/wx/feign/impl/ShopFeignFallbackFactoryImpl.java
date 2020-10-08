package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.ShopFeignAO;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service("shopFeignAO")
public class ShopFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<ShopFeignAO> {
    @Override
    public ShopFeignAO create(Throwable throwable) {
        return new ShopFeignAO() {
            @Override
            public Result<Shop> queryOneById(Long shopId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
