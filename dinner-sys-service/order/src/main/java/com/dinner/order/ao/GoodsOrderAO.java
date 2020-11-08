package com.dinner.order.ao;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsOrderAO {
    /**
     * <pre>
     * 新增 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderReq 用户订单
     * @return goodsOrderId
     */
    Result<Long> insertGoodsOrder(GoodsOrderReq goodsOrderReq);
    /**
     * <pre>
     * 根据ID删除 用户订单记录
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderId 用户订单Id
     * @return 改变数量
     */
    Result<Integer> deleteById(Long goodsOrderId);
    /**
     * <pre>
     * 根据ID查询 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderId  用户订单Id
     * @return GoodsOrder
     */
    Result<GoodsOrder> queryById(Long goodsOrderId);
    /**
     * <pre>
     * 分页查询 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page  分页信息
     * @param query 查询条件
     * @return      分页数据集合
     */
    PageResult<GoodsOrder>  queryPage(GoodsOrderQuery query);
    /**
     * <pre>
     * 根据ID修改 用户订单
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderReq 用户订单
     * @return 修改记录数量
     */
    Result<Integer> updateGoodsOrder(GoodsOrderReq goodsOrderReq);

    /**
     * <pre>
     * 集合查询 用户订单
     * </pre>
     *
     * @param query 查询条件
     * @return      数据集合
     */
    Result<List<GoodsOrder>> queryList( GoodsOrderQuery query);

    Result<Integer> saveByCollectIds(List<Long> goodsIds,Long shopId,Long userId);

}
