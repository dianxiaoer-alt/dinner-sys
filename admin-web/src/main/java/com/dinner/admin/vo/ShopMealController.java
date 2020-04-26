package com.dinner.admin.vo;

import com.dinner.admin.feign.ShopMealFeign;
import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.request.ShopMealReq;
import com.dinner.commons.result.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("shopMeal")
@RestController
@Slf4j
public class ShopMealController {

    @Autowired
    private ShopMealFeign insertShopMeal;

    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public Result<Long> save(  ShopMealReq shopMealReq) {

        return insertShopMeal.save(shopMealReq);
    }


    @RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<Integer> deleteById(@RequestParam("shopMealId")Long shopMealId) {
        return insertShopMeal.deleteById(shopMealId);
    }


    @RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<ShopMeal> queryById(@RequestParam("shopMealId")Long shopMealId) {
        log.info(String.valueOf(shopMealId));
        return insertShopMeal.queryById(shopMealId);
    }


    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<Integer> update( ShopMealReq shopMealReq) {
        log.info(shopMealReq.toString());
        return insertShopMeal.update(shopMealReq);
    }


    @RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<List<ShopMeal>> queryList( ShopMealQuery query) {
        return insertShopMeal.queryList(query);
    }

}
