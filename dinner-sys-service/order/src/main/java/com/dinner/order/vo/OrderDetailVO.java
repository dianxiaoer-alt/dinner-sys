package com.dinner.order.vo;

import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.OrderDetailQuery;
import com.dinner.commons.request.OrderDetailReq;
import com.dinner.commons.result.Result;
import com.dinner.order.ao.OrderDetailAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@Api(tags = "订单详情")
@RequestMapping("orderDetail")
@RestController
public class OrderDetailVO {
    /**
     * 订单详情应用流程对象
     */
    @Autowired
    private  OrderDetailAO orderDetailAO;


    @ApiOperation("保存订单详情")
    //@PostMapping("save")
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public Result<Long> save(@Valid @RequestBody OrderDetailReq orderDetailReq) {
        return orderDetailAO.insertOrderDetail(orderDetailReq);
    }

    @ApiOperation("根据ID删除订单详情")
    //@DeleteMapping("delete")
    @RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
    public Result<Integer> deleteById(Long orderDetailId) {
        return orderDetailAO.deleteById(orderDetailId);
    }

    @ApiOperation("根据ID查询订单详情")
    //@GetMapping("queryById")
    @RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<OrderDetail> queryById(Long orderDetailId) {
        return orderDetailAO.queryById(orderDetailId);
    }

    @ApiOperation("查询订单详情")
    //@GetMapping("queryPage")
    @RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
    public PageResult<OrderDetail> queryPage(OrderDetailQuery query) {
        return orderDetailAO.queryPage(query);
    }

    @ApiOperation("更新订单详情")
    //@PutMapping("update")
    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
    public Result<Integer> update(@Valid @RequestBody OrderDetailReq orderDetailReq) {
        return orderDetailAO.updateOrderDetail(orderDetailReq);
    }

    @ApiOperation("查询集合订单详情")
    @RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
    public Result<List<OrderDetail>> queryList(@Valid @RequestBody OrderDetailQuery query) {
        return orderDetailAO.queryList(query);
    }

}
