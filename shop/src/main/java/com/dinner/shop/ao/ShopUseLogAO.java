/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.ao;

import com.dinner.commons.domain.ShopUseLog;
import com.dinner.commons.query.ShopUseLogQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.ShopUseLogReq;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * <pre>
 *  应用对象，提供 相关流程应用操作、查询等
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
public interface ShopUseLogAO {
	/**
	 * <pre>
	 * 新增 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param shopUseLogReq 
	 * @return shopUseLogId
	 */
	Result<Long> insertShopUseLog(ShopUseLogReq shopUseLogReq);
	/**
	 * <pre>
	 * 根据ID删除 记录
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param shopUseLogId Id
	 * @return 改变数量
	 */
	Result<Integer> deleteById(Long shopUseLogId);
	/**
	 * <pre>
	 * 根据ID查询 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param shopUseLogId  Id
	 * @return ShopUseLog
	 */
	Result<ShopUseLog> queryById(Long shopUseLogId);

	/**
	 * <pre>
	 * 根据ID修改 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param shopUseLogReq 
	 * @return 修改记录数量
	 */
	Result<Integer> updateShopUseLog(ShopUseLogReq shopUseLogReq);

	/**
	 * <pre>
	 * 集合查询 
	 * </pre>
	 *
	 * @param query 查询条件
	 * @return      数据集合
	 */
	Result<List<ShopUseLog>> queryList(ShopUseLogQuery query);

	Result<PageInfo<ShopUseLog>> queryPage(ShopUseLogQuery query);

}
