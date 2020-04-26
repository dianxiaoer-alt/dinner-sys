package com.dinner.admin.feign;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;

import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {
    @RequestMapping(value="order/save")
    Result<Long> save(@RequestBody GoodsOrderReq goodsOrderReq);

    @GetMapping("order/delete")
    Result<Integer> deleteById(@RequestParam("goodsOrderId")Long goodsOrderId);
    /**
     * <pre>
     * 根据ID查询 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderId  用户订单Id
     * @return GoodsOrder
     */
    @GetMapping("order/queryById")
    Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId);


    @RequestMapping(value="order/queryPage")
    Result<PageInfo<GoodsOrder>> queryPage(@RequestBody GoodsOrderQuery query);
    /**
     * <pre>
     * 根据ID修改 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderReq 用户订单
     * @return 修改记录数量
     */
    @RequestMapping("order/update")
    Result<Integer> updateGoodsOrder(@RequestBody GoodsOrderReq goodsOrderReq);

    /**
     * <pre>
     * 集合查询 用户订单
     * </pre>
     *
     * @param query 查询条件
     * @return      数据集合
     */
    @GetMapping("order/queryList")
    Result<List<GoodsOrder>> queryList(@RequestBody GoodsOrderQuery query);

}
