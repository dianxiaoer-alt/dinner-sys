/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.dal;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.page.Page;
/**
 * <pre>
 *  店铺使用套餐数据操作对象，提供对店铺使用套餐新增，编辑，查询等操作。
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
public interface ShopMealDO {
    /**
     * <pre>
     *  保存店铺使用套餐
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param shopMeal 店铺使用套餐
     */
    int insertShopMeal(ShopMeal shopMeal);
    
    /**
     * <pre>
     * 	根据ID删除店铺使用套餐
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param  Id
     * @return 更改数量
     */
    int deleteById(Long Id);
    
    /**
     * <pre>
     * 	根据ID查询店铺使用套餐
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param Id
     * @return ShopMeal
     */
    ShopMeal queryById(Long Id);
    
    /**
     * <pre>
     * 	统计查询  店铺使用套餐 总数量
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param query 查询对象信息
     * @return 统计数量
     */
    int countPage(ShopMeal shopMeal);
    

   
     /**
     * <pre>
     * 	根据ID修改 店铺使用套餐
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param shopMeal 店铺使用套餐
     * @return 改变数量
     */
    int updateShopMeal(ShopMeal shopMeal);
     /**
     *
     * @param query  查询对象信息
     * @return 数据集合
     */
    List<ShopMeal> queryList(ShopMeal shopMeal);
}
