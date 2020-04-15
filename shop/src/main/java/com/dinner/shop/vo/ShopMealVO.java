/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.vo;

import javax.validation.Valid;


import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.ShopMealReq;

import com.dinner.shop.ao.ShopMealAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * <pre>
 *  店铺使用套餐控制对象，提供 店铺使用套餐 新增,编辑,查询等操作。
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
@Api(tags = "店铺使用套餐")
@RestController
@RequestMapping("shopMeal")
public class ShopMealVO {
	/**
	 * 店铺使用套餐应用流程对象
	 */
    @Autowired
	private final ShopMealAO shopMealAO;
	

	public ShopMealVO(ShopMealAO shopMealAO) {
		this.shopMealAO = shopMealAO;
	}
	
	@ApiOperation("保存店铺使用套餐")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save( @RequestBody ShopMealReq shopMealReq) {
		return shopMealAO.insertShopMeal(shopMealReq);
	}

	@ApiOperation("根据ID删除店铺使用套餐")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(Long shopMealId) {
		return shopMealAO.deleteById(shopMealId);
	}

	@ApiOperation("根据ID查询店铺使用套餐")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<ShopMeal> queryById(Long shopMealId) {
		return shopMealAO.queryById(shopMealId);
	}

	@ApiOperation("更新店铺使用套餐")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update( @RequestBody ShopMealReq shopMealReq) {
		return shopMealAO.updateShopMeal(shopMealReq);
	}

	@ApiOperation("查询集合店铺使用套餐")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<ShopMeal>> queryList( @RequestBody ShopMealQuery query) {
		return shopMealAO.queryList(query);
	}

}
