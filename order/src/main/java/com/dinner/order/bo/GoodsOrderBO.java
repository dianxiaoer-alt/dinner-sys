package com.dinner.order.bo;

import com.dinner.commons.domain.GoodsOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsOrderBO {
    /**
     * <pre>
     * 新增 用户订单
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrder 用户订单
     * @throws
     */
    int insertGoodsOrder(GoodsOrder goodsOrder);
    /**
     * <pre>
     * 根据ID删除 用户订单
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderId 用户订单Id
     * @return 更改数量
     * @throws
     */
    int deleteById(Long goodsOrderId);
    /**
     * <pre>
     * 分页查询用户订单
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page  分页信息
     * @param goodsOrder 查询条件
     * @return 数据集合
     * @throws
     */
    PageInfo<GoodsOrder> queryPage(GoodsOrder goodsOrder, int pageNum, int pageSize);
    /**
     * <pre>
     * 根据ID查询用户订单
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrderId 用户订单Id
     * @return GoodsOrder
     * @throws
     */
    GoodsOrder queryById(Long goodsOrderId);
    /**
     * <pre>
     * 根据ID修改用户订单
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsOrder 用户订单
     * @return 修改数量
     * @throws
     */
    int updateGoodsOrder(GoodsOrder goodsOrder);
    /**
     *
     * @param goodsOrder  查询对象信息
     * @return 数据集合
     */
    List<GoodsOrder> queryList(GoodsOrder goodsOrder);
}
