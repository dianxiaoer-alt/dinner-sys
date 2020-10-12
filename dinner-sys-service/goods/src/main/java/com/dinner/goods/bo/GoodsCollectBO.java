/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.bo;

import java.util.List;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.result.dto.GoodsCollectDTO;
import com.github.pagehelper.PageInfo;


/**
 * <pre>
 *  菜品购物车 业务逻辑操作对象，保持事务一致，尽量在这里减少操作时间，该层最好处理缓存机制、分页查询逻辑处理
 *  比如：初始化数据（除非跟数据库交互），尽量不要在该层操作，
 *  不然会拉长事务的时间，加大对数据库的锁（不一定是行锁、全数据锁）时间。
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
 * @version 1.0.0
 */
public interface GoodsCollectBO {
    /**
     * <pre>
     * 新增 菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect 菜品购物车
     * @throws 
     */
    int insertGoodsCollect(GoodsCollect goodsCollect);
    /**
     * <pre>
     * 根据ID删除 菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollectId 菜品购物车Id
     * @return 更改数量
     * @throws 
     */
    int deleteById(Long goodsCollectId);
    /**
     * <pre>
     * 分页查询菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect  条件
     * @param pageNum 当前页
     * @param pageSize 每页总数
     * @return 数据集合
     * @throws 
     */
     PageInfo<GoodsCollect> queryPage(GoodsCollect goodsCollect,int pageNum,int pageSize);
    /**
     * <pre>
     * 根据ID查询菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollectId 菜品购物车Id
     * @return GoodsCollect
     * @throws 
     */
    GoodsCollectDTO queryById(Long goodsCollectId);
    /**
     * <pre>
     * 根据ID修改菜品购物车
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsCollect 菜品购物车
     * @return 修改数量
     * @throws 
     */
    int updateGoodsCollect(GoodsCollect goodsCollect);
     /**
     *
     * @param goodsCollect  查询对象信息
     * @return 数据集合
     */
     List<GoodsCollectDTO> queryList(GoodsCollect goodsCollect);

    int changeDeleted(List<Long> idList);
}
