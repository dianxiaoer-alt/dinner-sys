/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.dal;

import java.util.List;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.result.dto.GoodsCollectDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * <pre>
 *  菜品购物车数据操作对象，提供对菜品购物车新增，编辑，查询等操作。
 *
 *  控制层统一命名规则：
 *  增加保存 	insertXX,
 *  修改保存 	updateXX,
 *  查询分页	queryPage,
 *  根据ID查询 	queryById,
 *  删除 		deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Mapper
public interface GoodsCollectDAO {
    /**
     * <pre>
     *  保存菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect 菜品购物车
     */
    int insertGoodsCollect(GoodsCollect goodsCollect);
    
    /**
     * <pre>
     * 	根据ID删除菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param  Id
     * @return 更改数量
     */
    int deleteById(Long Id);
    
    /**
     * <pre>
     * 	根据ID查询菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param Id
     * @return GoodsCollect
     */
    GoodsCollectDO  queryById(Long Id);
    
    /**
     * <pre>
     * 	统计查询  菜品购物车 总数量
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @return 统计数量
     */
    int countPage(GoodsCollect goodsCollect);
    
    /**
     * <pre>
     * 	分页查询 
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect
     * @return 分页查询数据集合
     */
    List<GoodsCollect> queryPage(GoodsCollect goodsCollect);
   
     /**
     * <pre>
     * 	根据ID修改 菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect 菜品购物车
     * @return 改变数量
     */
    int updateGoodsCollect(GoodsCollect goodsCollect);
     /**
     *
     * @return 数据集合
     */
    List<GoodsCollectDO > queryList(GoodsCollect goodsCollect);

    int changeDeleted(@Param("idList") List<Long> idList);
}
