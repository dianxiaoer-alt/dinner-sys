package com.dinner.admin.feign.impl;

import com.dinner.admin.contants.AbstractFallbackFactory;
import com.dinner.admin.feign.ShopFeign;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.domain.ShopDetail;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.ShopDetailQuery;
import com.dinner.commons.query.ShopQuery;
import com.dinner.commons.request.ShopDetailReq;
import com.dinner.commons.request.ShopReq;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 14:37
 */
@Service
public class ShopFeignFallbackFactoryImpl  extends AbstractFallbackFactory implements FallbackFactory<ShopFeign> {

    @Override
    public ShopFeign create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            log.error(msg);
        }
        return new ShopFeign() {
            @Override
            public Result<Long> save(ShopReq shopReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> deleteById(Long shopId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Shop> queryById(Long shopId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<PageInfo<Shop>> queryPage(ShopQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> update(ShopReq shopReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<Shop>> queryList(ShopQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Long> save(ShopDetailReq shopDetailReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> deleteShopDetailById(Long shopDetailId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<ShopDetail> queryShopDetailById(Long shopDetailId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> update(ShopDetailReq shopDetailReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<ShopDetail>> queryList(ShopDetailQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
