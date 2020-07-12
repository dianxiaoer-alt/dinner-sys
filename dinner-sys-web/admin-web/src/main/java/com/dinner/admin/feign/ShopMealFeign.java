package com.dinner.admin.feign;

import com.dinner.admin.feign.impl.ShopMealFeignFallbackFactoryImpl;
import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.request.ShopMealReq;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "shop" ,fallbackFactory = ShopMealFeignFallbackFactoryImpl.class)
public interface ShopMealFeign {
    @RequestMapping(value = "shopMeal/save")
     Result<Long> save(@RequestBody ShopMealReq shopMealReq);

    @RequestMapping(value = "shopMeal/delete")
     Result<Integer> deleteById(@RequestParam("shopMealId")Long shopMealId);

    @RequestMapping(value = "shopMeal/queryById")
     Result<ShopMeal> queryById(@RequestParam("shopMealId")Long shopMealId);

    @RequestMapping(value = "shopMeal/update")
     Result<Integer> update( @RequestBody ShopMealReq shopMealReq);

    @RequestMapping(value = "shopMeal/queryList")
     Result<List<ShopMeal>> queryList(@RequestBody ShopMealQuery query);
}
