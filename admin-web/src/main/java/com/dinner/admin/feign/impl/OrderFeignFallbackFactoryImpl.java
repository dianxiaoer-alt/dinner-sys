package com.dinner.admin.feign.impl;

import com.dinner.admin.contants.AbstractFallbackFactory;
import com.dinner.admin.feign.OrderFeign;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：熔断，降级
 *
 * @author:陈丽强
 * @Date:2020/5/2 21:55
 */
@Service
public class OrderFeignFallbackFactoryImpl  extends AbstractFallbackFactory implements FallbackFactory<OrderFeign> {

    @Override
    public OrderFeign create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            log.error(msg);
        }
        return new OrderFeign() {
            @Override
            public Result<Long> save(GoodsOrderReq goodsOrderReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> deleteById(Long goodsOrderId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<GoodsOrder> queryById(Long goodsOrderId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<PageInfo<GoodsOrder>> queryPage(GoodsOrderQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> updateGoodsOrder(GoodsOrderReq goodsOrderReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<GoodsOrder>> queryList(GoodsOrderQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
