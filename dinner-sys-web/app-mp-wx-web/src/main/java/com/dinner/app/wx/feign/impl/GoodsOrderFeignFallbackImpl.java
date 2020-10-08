package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.GoodsFeignAO;
import com.dinner.app.wx.feign.GoodsOrderFeignAO;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;

public class GoodsOrderFeignFallbackImpl extends AbstractFallbackFactory implements FallbackFactory<GoodsOrderFeignAO> {
    @Override
    public GoodsOrderFeignAO create(Throwable throwable) {
        return new GoodsOrderFeignAO() {
            @Override
            public Result<Integer> saveByCollectIds(String goodsCollectIds, Long shopId, Long userId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<GoodsOrder> queryById(Long goodsOrderId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
