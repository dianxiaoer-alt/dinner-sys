/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.ao;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.GoodsCollectDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import java.util.List;
/**
 * <pre>
 *  菜品购物车应用对象，提供 菜品购物车相关流程应用操作、查询等
 *  控制层统一命名规则：
 *  增加保存 	  insert,
 *  修改保存 	  update,
 *  查询以query开头，如：
 *  查询分页 	  queryPage,
 *  根据ID查询     queryById,
 *  删除必须以delete开头，如：
 *  根据ID删除     deleteById,
 *  
 *  校验统一使用 	  validate开头
 *  
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
public interface GoodsCollectAO {
	/**
	 * <pre>
	 * 新增 菜品购物车
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsCollectReq 菜品购物车
	 * @return goodsCollectId
	 */
	Result<Long> insertGoodsCollect(GoodsCollectReq goodsCollectReq);
	/**
	 * <pre>
	 * 根据ID删除 菜品购物车记录
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsCollectId 菜品购物车Id
	 * @return 改变数量
	 */
	Result<Integer> deleteById(Long goodsCollectId);
	/**
	 * <pre>
	 * 根据ID查询 菜品购物车
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsCollectId  菜品购物车Id
	 * @return GoodsCollect
	 */
	Result<GoodsCollectDO > queryById(Long goodsCollectId);
	/**
	 * <pre>
	 * 分页查询 菜品购物车
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param page  分页信息
	 * @param query 查询条件
	 * @return      分页数据集合
	 */
	PageResult<GoodsCollect> queryPage(GoodsCollectQuery query);
	/**
	 * <pre>
	 * 根据ID修改 菜品购物车
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsCollectReq 菜品购物车
	 * @return 修改记录数量
	 */
	Result<Integer> updateGoodsCollect(GoodsCollectReq goodsCollectReq);

	/**
	 * <pre>
	 * 集合查询 菜品购物车
	 * </pre>
	 *
	 * @param query 查询条件
	 * @return      数据集合
	 */
	Result<List<GoodsCollectDO >> queryList( GoodsCollectQuery query);

	Result<Integer> changeDeleted(List<Long> idList);



}
