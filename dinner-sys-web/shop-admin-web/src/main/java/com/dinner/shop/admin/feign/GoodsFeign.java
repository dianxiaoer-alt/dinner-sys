package com.dinner.shop.admin.feign;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.query.GoodsTypeQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.feign.impl.GoodsFeignFallbackFactoryImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品服务
 */
@FeignClient(value = "goods",fallbackFactory = GoodsFeignFallbackFactoryImpl.class)
public interface GoodsFeign {
    @RequestMapping(value = "goods/save")
    Result<Integer> save(@RequestBody GoodsReq goodsReq);

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


    @GetMapping("goods/queryListByTypeId")
     Result<List<Goods>> queryListByTypeId(@RequestParam("goods_type_id") Long goods_type_id);

   //某店铺下某分类下的菜品集合（已上架）
    @GetMapping("goods/queryListByTypeAndShop")
    Result<List<Goods>> queryListByTypeAndShop(@RequestParam("goods_type_id") Long goods_type_id, @RequestParam("goods_shop_id") Long goods_shop_id) ;


    @GetMapping("goods/queryListByShopId")
   Result<List<Goods>> queryListByShopId(@RequestParam("goods_shop_id") Long goods_shop_id);

    @GetMapping("goods/onSaleOrNo")
    Result<Integer> onSaleOrNo(@RequestParam("goods_id")Long goods_id,@RequestParam("is_on_sale")Integer is_on_sale);

    /**********goodsType**********/
    @PostMapping("goodsType/queryList")
    Result<List<GoodsType>> queryGoodsTypeList(@RequestBody GoodsTypeQuery goodsTypeQuery);

    @PostMapping("goodsType/update")
    Result<Integer> goodsTypeUpdate( @RequestBody GoodsTypeReq goodsTypeReq);

    @GetMapping("goodsType/delete")
    Result<Integer> goodsTypeDelete(@RequestParam("id")Long id);

    @GetMapping("goodsType/queryOneById")
    Result<GoodsType> goodsTypeQueryOneById(@RequestParam("id") Long id);

    @PostMapping("goodsType/insert")
    Result<Integer> goodsTypeInsert(@RequestBody GoodsTypeReq goodsTypeReq);

}
