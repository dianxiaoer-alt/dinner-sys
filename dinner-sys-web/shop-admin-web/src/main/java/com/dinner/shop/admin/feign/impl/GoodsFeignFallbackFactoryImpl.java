package com.dinner.shop.admin.feign.impl;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.constant.AbstractFallbackFactory;
import com.dinner.shop.admin.feign.GoodsFeign;
import com.github.pagehelper.PageInfo;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：熔断机制
 *
 * @author:陈丽强
 * @Date:2020/5/2 16:18
 */
@Service
public class GoodsFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<GoodsFeign> {

    @Override
    public GoodsFeign create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            log.error(msg);
        }
        return new GoodsFeign() {

            @Override
            public Result<Integer> save(GoodsReq goodsReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> deleteById(Long goodsId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Goods> queryById(Long goodsId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<PageInfo<Goods>> queryPage(GoodsQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> update(GoodsReq goodsReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<Goods>> queryList(GoodsQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<Goods>> queryListByTypeId(Long goods_type_id) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<Goods>> queryListByTypeAndShop(Long goods_type_id, Long goods_shop_id) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<Goods>> queryListByShopId(Long goods_shop_id) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
