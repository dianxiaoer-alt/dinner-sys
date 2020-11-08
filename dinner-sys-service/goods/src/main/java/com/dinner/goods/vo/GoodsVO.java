package com.dinner.goods.vo;

import com.dinner.commons.domain.Goods;

import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.result.Result;
import com.dinner.goods.ao.GoodsAO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Api(tags = "菜品表")
@RestController
@RequestMapping("goods")
public class GoodsVO {
    /**
     * 菜品表应用流程对象
     */
    @Autowired
    private  GoodsAO goodsAO;



    @ApiOperation("保存菜品表")
    //@PostMapping("save")
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public Result<Long> save(@Valid @RequestBody GoodsReq goodsReq) {
        return goodsAO.insertGoods(goodsReq);
    }

    @ApiOperation("根据ID删除菜品表")
    //@DeleteMapping("delete")
    @RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
    public Result<Integer> deleteById(@RequestParam("goodsId") Long goodsId) {
        return goodsAO.deleteById(goodsId);
    }

    @ApiOperation("根据ID查询菜品表")
    //@GetMapping("queryById")
    @RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<Goods> queryById(@RequestParam("goodsId") Long goodsId) {
        return goodsAO.queryById(goodsId);
    }

    @ApiOperation("查询菜品表")
    //@GetMapping("queryPage")
    @RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<PageInfo<Goods>> queryPage(@RequestBody GoodsQuery query) {
        return goodsAO.queryPage( query);
    }

    @ApiOperation("更新菜品表")
    //@PutMapping("update")
    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
    public Result<Integer> update( @RequestBody GoodsReq goodsReq) {
        return goodsAO.updateGoods(goodsReq);
    }

    @ApiOperation("查询集合菜品表")
    @PostMapping(value = "queryAllList")
    public Result<List<Goods>> queryList( @RequestBody GoodsQuery query) {
        return goodsAO.queryList(query);
    }


    @ApiOperation("某分类下的菜品集合（已上架）")
    @GetMapping("queryListByTypeId")
    public Result<List<Goods>> queryListByTypeId(@RequestParam("goods_type_id") Long goods_type_id) {
        return goodsAO.queryListByTypeId(goods_type_id);
    }


    @ApiOperation("某店铺下某分类下的菜品集合（已上架）")
    @GetMapping("queryListByTypeAndShop")
    public Result<List<Goods>> queryListByTypeAndShop(@RequestParam("goods_type_id") Long goods_type_id,@RequestParam("goods_shop_id") Long goods_shop_id) {
        return goodsAO.queryListByTypeAndShop(goods_type_id,goods_shop_id);
    }

    @ApiOperation("店铺的菜品集合（已上架）")
    @GetMapping("queryListByShopId")
    public Result<List<Goods>> queryListByShopId(@RequestParam("goods_shop_id")Long goods_shop_id) {
        return goodsAO.queryListByShopId(goods_shop_id);
    }

    @GetMapping("onSaleOrNo")
    public Result<Integer> onSaleOrNo(@RequestParam("goods_id")Long goods_id,@RequestParam("is_on_sale")Integer is_on_sale){
        return goodsAO.onSaleOrNo(goods_id,is_on_sale);
    }

}
