package com.dinner.order.vo;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import com.dinner.order.ao.GoodsOrderAO;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "订单")
@RestController
@RequestMapping("order")
@Slf4j
public class GoodsOrderVO {

    @Autowired
    private GoodsOrderAO goodsOrderAO;

    @ApiOperation("保存用户订单")
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public Result<Long> save(@RequestBody GoodsOrderReq goodsOrderReq) {
        return goodsOrderAO.insertGoodsOrder(goodsOrderReq);
    }

    @ApiOperation("根据ID删除用户订单")
    //@DeleteMapping("delete")
    @RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
    public Result<Integer> deleteById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return goodsOrderAO.deleteById(goodsOrderId);
    }

    @ApiOperation("根据ID查询用户订单")
    //@GetMapping("queryById")
    @RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return goodsOrderAO.queryById(goodsOrderId);
    }

    @ApiOperation("查询用户订单")
    //@GetMapping("queryPage")
    @RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<PageInfo<GoodsOrder>> queryPage(@RequestBody  GoodsOrderQuery query) {
        log.info(ReflectionToStringBuilder.toString(query));
        return goodsOrderAO.queryPage( query);
    }

    @ApiOperation("更新用户订单")
    //@PutMapping("update")
    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
    public Result<Integer> update(@RequestBody  GoodsOrderReq goodsOrderReq) {
        return goodsOrderAO.updateGoodsOrder(goodsOrderReq);
    }
        @ApiOperation("查询集合用户订单")
        @RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
        public Result<List<GoodsOrder>> queryList(@RequestBody  GoodsOrderQuery query) {
            return goodsOrderAO.queryList(query);
        }
}
