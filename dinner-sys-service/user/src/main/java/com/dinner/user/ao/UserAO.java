/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.ao;

import com.dinner.commons.domain.User;
import com.dinner.commons.query.UserQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.UserReq;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * <pre>
 *  微信登录授权用户表应用对象，提供 微信登录授权用户表相关流程应用操作、查询等
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
public interface UserAO {
	/**
	 * <pre>
	 * 新增 微信登录授权用户表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param userReq 微信登录授权用户表
	 * @return userId
	 */
	Result<Long> insertUser(UserReq userReq);
	/**
	 * <pre>
	 * 根据ID删除 微信登录授权用户表记录
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param userId 微信登录授权用户表Id
	 * @return 改变数量
	 */
	Result<Integer> deleteById(Long userId);
	/**
	 * <pre>
	 * 根据ID查询 微信登录授权用户表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param userId  微信登录授权用户表Id
	 * @return User
	 */
	Result<User> queryById(Long userId);
	/**
	 * <pre>
	 * 分页查询 微信登录授权用户表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param page  分页信息
	 * @param query 查询条件
	 * @return      分页数据集合
	 */
	Result<PageInfo<User>> queryPage(UserQuery query);
	/**
	 * <pre>
	 * 根据ID修改 微信登录授权用户表
	 * // TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
	 * </pre>
	 *
	 * @param userReq 微信登录授权用户表
	 * @return 修改记录数量
	 */
	Result<Integer> updateUser(UserReq userReq);

	/**
	 * <pre>
	 * 集合查询 微信登录授权用户表
	 * </pre>
	 *
	 * @param query 查询条件
	 * @return      数据集合
	 */
	Result<List<User>> queryList(UserQuery query);


	Result<User> queryUserByOpenId(String openId);
}
