/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.message.ao;

import com.dinner.commons.domain.Message;
import com.dinner.commons.query.MessageQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.MessageReq;
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
public interface MessageAO {
	/**
	 * <pre>
	 * 新增 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param messageReq 
	 * @return messageId
	 */
	Result<Long> insertMessage(MessageReq messageReq);
	/**
	 * <pre>
	 * 根据ID删除 记录
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param messageId Id
	 * @return 改变数量
	 */
	Result<Integer> deleteById(Long messageId);
	/**
	 * <pre>
	 * 根据ID查询 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param messageId  Id
	 * @return Message
	 */
	Result<Message> queryById(Long messageId);
	/**
	 * <pre>
	 * 分页查询 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param page  分页信息
	 * @param query 查询条件
	 * @return      分页数据集合
	 */
	Result<PageInfo<Message>> queryPage(MessageQuery query);
	/**
	 * <pre>
	 * 根据ID修改 
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param messageReq 
	 * @return 修改记录数量
	 */
	Result<Integer> updateMessage(MessageReq messageReq);

	/**
	 * <pre>
	 * 集合查询 
	 * </pre>
	 *
	 * @param query 查询条件
	 * @return      数据集合
	 */
	Result<List<Message>> queryList(MessageQuery query);

}
