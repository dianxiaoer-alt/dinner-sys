/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.coupon.dal;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dinner.commons.domain.ShopCoupon;
import com.dinner.commons.query.ShopCouponQuery;
import com.dinner.commons.page.Page;
/**
 * <pre>
 *  数据操作对象，提供对新增，编辑，查询等操作。
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
public interface ShopCouponDO {
    /**
     * <pre>
     *  保存
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param shopCoupon 
     */
    int insertShopCoupon(ShopCoupon shopCoupon);
    
    /**
     * <pre>
     * 	根据ID删除
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param  Id
     * @return 更改数量
     */
    int deleteById(Long Id);
    
    /**
     * <pre>
     * 	根据ID查询
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param Id
     * @return ShopCoupon
     */
    ShopCoupon queryById(Long Id);
    
    /**
     * <pre>
     * 	统计查询   总数量
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param query 查询对象信息
     * @return 统计数量
     */
    int countPage(ShopCoupon shopCoupon);
    
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
    List<ShopCoupon> queryPage(@Param("page") Page page, @Param("query") ShopCoupon query);
   
     /**
     * <pre>
     * 	根据ID修改 
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param shopCoupon 
     * @return 改变数量
     */
    int updateShopCoupon(ShopCoupon shopCoupon);
     /**
     *
     * @param query  查询对象信息
     * @return 数据集合
     */
    List<ShopCoupon> queryList(ShopCoupon shopCoupon);
}
