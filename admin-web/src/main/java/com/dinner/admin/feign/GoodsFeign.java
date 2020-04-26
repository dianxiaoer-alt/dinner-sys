package com.dinner.admin.feign;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 商品服务
 */
@FeignClient(value = "goods")
public interface GoodsFeign {
    @RequestMapping(value = "goods/save")
    Result<Integer> save( @RequestBody GoodsReq goodsReq);

    @GetMapping(value = "goods/delete")
    Result<Integer> deleteById(@RequestParam("goodsId") Long goodsId);

    @GetMapping(value = "goods/queryById")
    Result<Goods> queryById(@RequestParam("goodsId") Long goodsId);

    @RequestMapping(value = "goods/queryPage")
    Result<PageInfo<Goods>> queryPage(@RequestBody GoodsQuery query);

    @RequestMapping(value = "goods/update")
    Result<Integer> update(@RequestBody GoodsReq goodsReq);

    @RequestMapping(value = "goods/queryAllList")
    Result<List<Goods>> queryList(@RequestBody GoodsQuery query);


    @GetMapping("queryListByTypeId")
     Result<List<Goods>> queryListByTypeId(@RequestParam("goods_type_id") Long goods_type_id);

   //某店铺下某分类下的菜品集合（已上架）
    @GetMapping("queryListByTypeAndShop")
    Result<List<Goods>> queryListByTypeAndShop(@RequestParam("goods_type_id") Long goods_type_id, @RequestParam("goods_shop_id") Long goods_shop_id) ;


    @GetMapping("queryListByShopId")
   Result<List<Goods>> queryListByShopId(@RequestParam("goods_shop_id")Long goods_shop_id);
}
