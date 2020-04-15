/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.vo;

import javax.validation.Valid;


import com.dinner.commons.domain.AdminUser;
import com.dinner.commons.query.AdminUserQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.AdminUserReq;

import com.dinner.user.ao.AdminUserAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * <pre>
 *  后台管理员用户控制对象，提供 后台管理员用户 新增,编辑,查询等操作。
 *  控制层统一命名规则：
 *  新增提供数据      add,
 *  增加保存 	  save,
 *  修改提供数据      edit,
 *  修改保存 	  update,
 *  查询分页 	  queryPage,
 *  根据ID查询 	  get,
 *  根据ID删除         deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @version 1.0.0
 */
@Api(tags = "后台管理员用户")
@RestController
@RequestMapping("adminUser")
public class AdminUserVO {
	/**
	 * 后台管理员用户应用流程对象
	 */
    @Autowired
	private final AdminUserAO adminUserAO;
	

	public AdminUserVO(AdminUserAO adminUserAO) {
		this.adminUserAO = adminUserAO;
	}
	
	@ApiOperation("保存后台管理员用户")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@Valid @RequestBody AdminUserReq adminUserReq) {
		return adminUserAO.insertAdminUser(adminUserReq);
	}

	@ApiOperation("根据ID删除后台管理员用户")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("adminUserId")Long adminUserId) {
		return adminUserAO.deleteById(adminUserId);
	}

	@ApiOperation("根据ID查询后台管理员用户")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<AdminUser> queryById(@RequestParam("adminUserId") Long adminUserId) {
		return adminUserAO.queryById(adminUserId);
	}

	@ApiOperation("查询后台管理员用户，分页不可用")
	@RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
	public PageResult<AdminUser> queryPage(@RequestBody AdminUserQuery query) {
		return adminUserAO.queryPage(query);
	}

	@ApiOperation("更新后台管理员用户")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody AdminUserReq adminUserReq) {
		return adminUserAO.updateAdminUser(adminUserReq);
	}

	@ApiOperation("查询集合后台管理员用户")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<AdminUser>> queryList(@RequestBody AdminUserQuery query) {
		return adminUserAO.queryList(query);
	}


	@ApiOperation("通过用户名查管理员用户")
	@RequestMapping("queryUserByUserName")
	public Result<AdminUser> queryUserByUserName(@RequestParam("username") String username){
		return adminUserAO.queryUserByUserName(username);
	}
}
