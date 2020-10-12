package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.GoodsCollectFeignAO;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.GoodsCollectDTO;
import feign.hystrix.FallbackFactory;

import javax.validation.Valid;
import java.util.List;

public class GoodsCollectFeignFallbackImpl extends AbstractFallbackFactory implements FallbackFactory<GoodsCollectFeignAO> {
    @Override
    public GoodsCollectFeignAO create(Throwable throwable) {
        return new GoodsCollectFeignAO() {
            @Override
            public Result<Long> save(@Valid GoodsCollectReq goodsCollectReq) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<Integer> update(@Valid GoodsCollectReq goodsCollectReq) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<List<GoodsCollectDTO>> queryList(@Valid GoodsCollectQuery query) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<Integer> deleteById(Long goodsCollectId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<GoodsCollectDTO> queryById(Long goodsCollectId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<Integer> changeDeleted(String goodsCollectIds) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
