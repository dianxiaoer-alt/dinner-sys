/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.order.dal;

import java.util.List;

import com.dinner.commons.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *  订单详情数据操作对象，提供对订单详情新增，编辑，查询等操作。
 *
 *  控制层统一命名规则：
 *  增加保存 	insertXX,
 *  修改保存 	updateXX,
 *  查询分页 	queryPage,
 *  根据ID查询 	queryById,
 *  删除 		deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Mapper
public interface OrderDetailDO {
    /**
     * <pre>
     *  保存订单详情
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetail 订单详情
     */
    int insertOrderDetail(OrderDetail orderDetail);
    
    /**
     * <pre>
     * 	根据ID删除订单详情
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param  Id
     * @return 更改数量
     */
    int deleteById(Long Id);
    
    /**
     * <pre>
     * 	根据ID查询订单详情
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param Id
     * @return OrderDetail
     */
    OrderDetail queryById(Long Id);
    
    /**
     * <pre>
     * 	统计查询  订单详情 总数量
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param query 查询对象信息
     * @return 统计数量
     */
    int countPage(OrderDetail orderDetail);
    
    /**
     * <pre>
     * 	分页查询 
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page   分页信息
     * @param query  查询对象信息
     * @return 数据集合
     */
    List<OrderDetail> queryPage(OrderDetail query);
   
     /**
     * <pre>
     * 	根据ID修改 订单详情
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param orderDetail 订单详情
     * @return 改变数量
     */
    int updateOrderDetail(OrderDetail orderDetail);
     /**
     *
     * @param query  查询对象信息
     * @return 数据集合
     */
    List<OrderDetail> queryList(OrderDetail orderDetail);

    List<OrderDetail> queryListByOrderId(@Param("orderId")Long orderId);
}
