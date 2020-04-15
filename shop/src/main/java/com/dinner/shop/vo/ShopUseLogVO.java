/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.vo;

import javax.validation.Valid;


import com.dinner.commons.domain.ShopUseLog;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopUseLogQuery;
import com.dinner.commons.request.ShopUseLogReq;
import com.dinner.commons.result.Result;
import com.dinner.shop.ao.ShopUseLogAO;
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
@Api(tags = "店铺套餐使用记录")
@RestController
@RequestMapping("shopUseLog")
public class ShopUseLogVO {
	/**
	 * 应用流程对象
	 */
    @Autowired
	private final ShopUseLogAO shopUseLogAO;
	

	public ShopUseLogVO(ShopUseLogAO shopUseLogAO) {
		this.shopUseLogAO = shopUseLogAO;
	}
	
	@ApiOperation("保存")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@RequestBody ShopUseLogReq shopUseLogReq) {
		return shopUseLogAO.insertShopUseLog(shopUseLogReq);
	}

	@ApiOperation("根据ID删除")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("shopUseLogId")Long shopUseLogId) {
		return shopUseLogAO.deleteById(shopUseLogId);
	}

	@ApiOperation("根据ID查询")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<ShopUseLog> queryById(@RequestParam("shopUseLogId") Long shopUseLogId) {
		return shopUseLogAO.queryById(shopUseLogId);
	}


	@ApiOperation("更新")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody ShopUseLogReq shopUseLogReq) {
		return shopUseLogAO.updateShopUseLog(shopUseLogReq);
	}

	@ApiOperation("查询集合")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<ShopUseLog>> queryList(@RequestBody ShopUseLogQuery query) {
		return shopUseLogAO.queryList(query);
	}

	@ApiOperation("分页查询集合")
	@RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<PageInfo<ShopUseLog>> queryPage(@RequestBody ShopUseLogQuery query) {
		return shopUseLogAO.queryPage(query);
	}

}
