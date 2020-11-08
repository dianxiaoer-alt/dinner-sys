package com.dinner.shop.admin.feign.impl;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.constant.AbstractFallbackFactory;
import com.dinner.shop.admin.feign.UserOrderFeign;
import com.github.pagehelper.PageInfo;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserOrderFeignFallbackFactory extends AbstractFallbackFactory implements FallbackFactory<UserOrderFeign> {
    @Override
    public UserOrderFeign create(Throwable cause) {
        String msg = cause == null ? "" : cause.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            log.error(msg);
        }
        return new UserOrderFeign() {
            @Override
            public Result<List<GoodsOrder>> queryList(GoodsOrderQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public  PageResult<GoodsOrder> queryPage(GoodsOrderQuery query) {
                return PageResult.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<GoodsOrder> queryById(Long goodsOrderId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<OrderDetail> queryOrderDetailById(Long orderDetailId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
