/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.vo;

import javax.servlet.http.HttpServletRequest;



import com.dinner.commons.domain.Shop;
import com.dinner.commons.query.ShopQuery;
import com.dinner.commons.request.ShopReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.utils.IPUtils;
import com.dinner.shop.ao.ShopAO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * <pre>
 *  控制对象，提供  新增,编辑,查询等操作。
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
@Api(tags = "店铺")
@RestController
@RequestMapping("shop")
public class ShopVO {
	/**
	 * 应用流程对象
	 */
    @Autowired
	private ShopAO shopAO;

	@ApiOperation("保存")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@RequestBody ShopReq shopReq) {
		return shopAO.insertShop(shopReq);
	}

	@ApiOperation("根据ID删除")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("shopId") Long shopId) {
		return shopAO.deleteById(shopId);
	}

	@ApiOperation("根据ID查询")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<Shop> queryById(@RequestParam("shopId") Long shopId) {
		return shopAO.queryById(shopId);
	}

	@ApiOperation("查询")
	//@GetMapping("queryPage")
	@RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<PageInfo<Shop>> queryPage(@RequestBody ShopQuery query) {
		return shopAO.queryPage(query);
	}

	@ApiOperation("更新")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody ShopReq shopReq) {
		return shopAO.updateShop(shopReq);
	}

	@ApiOperation("查询集合")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<Shop>> queryList(@RequestBody ShopQuery query) {
		return shopAO.queryList(query);
	}

	@ApiOperation("店铺登录")
	@GetMapping("shopLoginByTelOrEmail")
	public Result<Shop> shopLoginByTelOrEmail(@RequestParam("value") String value,@RequestParam("password") String password, HttpServletRequest request){
		return shopAO.shopLoginByTelOrEmail(value,password, IPUtils.getIpAddr(request));
	}
}
