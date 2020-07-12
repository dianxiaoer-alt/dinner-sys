/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.ao.impl;

import com.dinner.commons.domain.AdminUser;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.AdminUserQuery;
import com.dinner.commons.request.AdminUserReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.user.ao.AdminUserAO;
import com.dinner.user.bo.AdminUserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




/**
 * <pre>
 *   默认 后台管理员用户应用实现类，提供后台管理员用户相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("adminUserAO")
public class AdminUserAOImpl  implements AdminUserAO {
	/**
	 * 后台管理员用户业务操作对象
	 */
    @Autowired
	private AdminUserBO adminUserManager;
	

	@Override
	public Result<Long> insertAdminUser(AdminUserReq adminUserReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				AdminUser adminUser = new AdminUser();
				BeanUtils.copyProperties(adminUserReq, adminUser);
				adminUserManager.insertAdminUser(adminUser);
				resp = Result.success(adminUser.getId());
			}
		} catch (Exception e) {
				resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long adminUserId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = adminUserManager.deleteById(adminUserId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<AdminUser> queryById(Long adminUserId) {
		Result<AdminUser> resp = new Result<>();
		try {
			AdminUser adminUser = adminUserManager.queryById(adminUserId);
		    resp = Result.success(adminUser);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public PageResult<AdminUser> queryPage(AdminUserQuery query) {
		PageResult<AdminUser> pr = new PageResult<>();
		try {
			AdminUser adminUser = new AdminUser();
			BeanUtils.copyProperties(query,adminUser);
			List<AdminUser> list = adminUserManager.queryPage(adminUser);

		} catch (Exception e) {
			pr =pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return pr;
	}

	@Override
	public Result<Integer> updateAdminUser(AdminUserReq adminUserReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				AdminUser adminUser = new AdminUser();
				BeanUtils.copyProperties(adminUserReq, adminUser);
				int flag = adminUserManager.updateAdminUser(adminUser);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<AdminUser>> queryList( AdminUserQuery query){
		Result<List<AdminUser>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				AdminUser adminUser = new AdminUser();
				BeanUtils.copyProperties(query, adminUser);
				List<AdminUser> list = adminUserManager.queryList(adminUser);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<AdminUser> queryUserByUserName(String username) {
		Result<AdminUser> resp = new Result<>();
		try {
			AdminUser adminUser = adminUserManager.queryUserByUserName(username);
			resp = Result.success(adminUser);
		}catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
