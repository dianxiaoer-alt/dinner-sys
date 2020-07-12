package com.dinner.admin.feign.impl;

import com.dinner.admin.contants.AbstractFallbackFactory;
import com.dinner.admin.feign.ShopMealFeign;
import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.request.ShopMealReq;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 14:40
 */
@Service
public class ShopMealFeignFallbackFactoryImpl  extends AbstractFallbackFactory implements FallbackFactory<ShopMealFeign> {
    @Override
    public ShopMealFeign create(Throwable throwable) {
        return new ShopMealFeign() {
            @Override
            public Result<Long> save(ShopMealReq shopMealReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> deleteById(Long shopMealId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<ShopMeal> queryById(Long shopMealId) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<Integer> update(ShopMealReq shopMealReq) {
                return Result.error(ERR_CODE,ERR_MSG);
            }

            @Override
            public Result<List<ShopMeal>> queryList(ShopMealQuery query) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
