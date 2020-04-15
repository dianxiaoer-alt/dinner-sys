/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.vo;

import javax.validation.Valid;

import com.dinner.user.ao.UserAO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinner.commons.domain.User;
import com.dinner.commons.query.UserQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.UserReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * <pre>
 *  微信登录授权用户表控制对象，提供 微信登录授权用户表 新增,编辑,查询等操作。
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
@Api(tags = "微信登录授权用户表")
@RestController
@RequestMapping("user")
public class UserVO {
	/**
	 * 微信登录授权用户表应用流程对象
	 */
    @Autowired
	private final UserAO userAO;
	

	public UserVO(UserAO userAO) {
		this.userAO = userAO;
	}
	
	@ApiOperation("保存微信登录授权用户表")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@RequestBody UserReq userReq) {
		return userAO.insertUser(userReq);
	}

	@ApiOperation("根据ID删除微信登录授权用户表")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("userId") Long userId) {
		return userAO.deleteById(userId);
	}

	@ApiOperation("根据ID查询微信登录授权用户表")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<User> queryById(@RequestParam("userId")Long userId) {
		return userAO.queryById(userId);
	}

	@ApiOperation("查询微信登录授权用户表，分页可用")
	//@GetMapping("queryPage")
	@RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<PageInfo<User>> queryPage(@RequestBody UserQuery query) {
		return userAO.queryPage( query);
	}

	@ApiOperation("更新微信登录授权用户表")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody UserReq userReq) {
		return userAO.updateUser(userReq);
	}

	@ApiOperation("查询集合微信登录授权用户表")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<User>> queryList(@RequestBody  UserQuery query) {
		return userAO.queryList(query);
	}

}
