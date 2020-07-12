/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.ao;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;

import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.GoodsReq;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * <pre>
 *  菜品表应用对象，提供 菜品表相关流程应用操作、查询等
 *  控制层统一命名规则：
 *  增加保存 	  insert,
 *  修改保存 	  update,
 *  查询以query开头，如：
 *    查询分页 	  queryPage,
 *    根据ID查询     queryById,
 *  删除必须以delete开头，如：
 *    根据ID删除     deleteById,
 *  
 *  校验统一使用 	  validate开头
 *  
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
public interface GoodsAO {
	/**
	 * <pre>
	 * 新增 菜品表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsReq 菜品表
	 * @return goodsId
	 */
	Result<Long> insertGoods(GoodsReq goodsReq);
	/**
	 * <pre>
	 * 根据ID删除 菜品表记录
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsId 菜品表Id
	 * @return 改变数量
	 */
	Result<Integer> deleteById(Long goodsId);
	/**
	 * <pre>
	 * 根据ID查询 菜品表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsId  菜品表Id
	 * @return Goods
	 */
	Result<Goods> queryById(Long goodsId);
	/**
	 * <pre>
	 * 分页查询 菜品表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param page  分页信息
	 * @param query 查询条件
	 * @return      分页数据集合
	 */
	Result<PageInfo<Goods>> queryPage(GoodsQuery query);
	/**
	 * <pre>
	 * 根据ID修改 菜品表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param goodsReq 菜品表
	 * @return 修改记录数量
	 */
	Result<Integer> updateGoods(GoodsReq goodsReq);

	/**
	 * <pre>
	 * 集合查询 菜品表
	 * </pre>
	 *
	 * @param query 查询条件
	 * @return      数据集合
	 */
	Result<List<Goods>> queryList(GoodsQuery query);


	/**
	 * 某分类下的菜品集合（已上架）
	 * @param goods_type_id
	 * @return
	 */
	Result<List<Goods>> queryListByTypeId(Long goods_type_id);

	/**
	 * 某店铺下某分类下的菜品集合（已上架）
	 * @param goods_type_id
	 * @param goods_shop_id
	 * @return
	 */
	Result<List<Goods>> queryListByTypeAndShop(Long goods_type_id,Long goods_shop_id);

	/**
	 * 某店铺的菜品集合（已上架）
	 * @param goods_shop_id
	 * @return
	 */
	Result<List<Goods>> queryListByShopId(Long goods_shop_id);
}
