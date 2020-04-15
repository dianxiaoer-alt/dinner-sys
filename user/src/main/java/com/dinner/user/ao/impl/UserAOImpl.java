/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.ao.impl;

import com.dinner.commons.domain.User;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.UserQuery;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.user.ao.UserAO;
import com.dinner.user.bo.UserBO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *   默认 微信登录授权用户表应用实现类，提供微信登录授权用户表相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("userAO")
public class UserAOImpl implements UserAO {
	/**
	 * 微信登录授权用户表业务操作对象
	 */
    @Autowired
	private UserBO userManager;
	

	
	@Override
	public Result<Long> insertUser(UserReq userReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				User user = new User();
				BeanUtils.copyProperties(userReq, user);
				userManager.insertUser(user);
				resp = Result.success(user.getId());
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long userId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = userManager.deleteById(userId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<User> queryById(Long userId) {
		Result<User> resp = new Result<>();
		try {
			User user = userManager.queryById(userId);
		    resp = Result.success(user);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<PageInfo<User>> queryPage( UserQuery query) {
		Result<PageInfo<User>> pr = new Result<>();
		try {
			User user = new User();
			BeanUtils.copyProperties(query,user);
			PageInfo<User> res = userManager.queryPage( user,query.getPageNum(),query.getPageSize());
			pr = Result.success(res);
		} catch (Exception e) {
			pr =pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return pr;
	}

	@Override
	public Result<Integer> updateUser(UserReq userReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				User user = new User();
				BeanUtils.copyProperties(userReq, user);
				int flag = userManager.updateUser(user);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<User>> queryList( UserQuery query){
		Result<List<User>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				User user = new User();
				BeanUtils.copyProperties(query, user);
				List<User> list = userManager.queryList(user);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
