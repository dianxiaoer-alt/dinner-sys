package com.dinner.admin.vo;

import com.dinner.admin.feign.OrderFeign;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")

public class OrderController {
    @Autowired
    private OrderFeign orderFeign;

    @PostMapping("save")
    public Result<Long> save(@RequestBody GoodsOrderReq goodsOrderReq){
        return orderFeign.save(goodsOrderReq);
    }

    @GetMapping(value = "delete")
    public Result<Integer> deleteById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return orderFeign.deleteById(goodsOrderId);
    }


    @GetMapping(value = "queryById")
    public Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return orderFeign.queryById(goodsOrderId);
    }



    @RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<PageInfo<GoodsOrder>> queryPage(@RequestBody GoodsOrderQuery query) {
        return orderFeign.queryPage( query);
    }


    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
    public Result<Integer> update(@RequestBody GoodsOrderReq goodsOrderReq) {
        return orderFeign.updateGoodsOrder(goodsOrderReq);
    }

    @RequestMapping(value = "queryList")
    public Result<List<GoodsOrder>> queryList(@RequestBody GoodsOrderQuery query) {
        return orderFeign.queryList(query);

    }
}
