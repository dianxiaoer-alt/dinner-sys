package com.dinner.order.ao;

import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.OrderDetailQuery;
import com.dinner.commons.request.OrderDetailReq;
import com.dinner.commons.result.Result;

import java.util.List;

public interface OrderDetailAO {
    /**
     * <pre>
     * 新增 订单详情
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetailReq 订单详情
     * @return orderDetailId
     */
    Result<Long> insertOrderDetail(OrderDetailReq orderDetailReq);
    /**
     * <pre>
     * 根据ID删除 订单详情记录
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetailId 订单详情Id
     * @return 改变数量
     */
    Result<Integer> deleteById(Long orderDetailId);
    /**
     * <pre>
     * 根据ID查询 订单详情
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetailId  订单详情Id
     * @return OrderDetail
     */
    Result<OrderDetail> queryById(Long orderDetailId);
    /**
     * <pre>
     * 分页查询 订单详情
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page  分页信息
     * @param query 查询条件
     * @return      分页数据集合
     */
    PageResult<OrderDetail> queryPage(OrderDetailQuery query);
    /**
     * <pre>
     * 根据ID修改 订单详情
     * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetailReq 订单详情
     * @return 修改记录数量
     */
    Result<Integer> updateOrderDetail(OrderDetailReq orderDetailReq);

    /**
     * <pre>
     * 集合查询 订单详情
     * </pre>
     *
     * @param query 查询条件
     * @return      数据集合
     */
    Result<List<OrderDetail>> queryList(OrderDetailQuery query);

}
