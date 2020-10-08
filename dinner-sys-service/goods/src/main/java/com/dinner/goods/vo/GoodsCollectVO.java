/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.vo;

import javax.validation.Valid;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.GoodsCollectDO;
import com.dinner.goods.ao.GoodsCollectAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <pre>
 *  菜品购物车控制对象，提供 菜品购物车 新增,编辑,查询等操作。
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
@Api(tags = "菜品购物车")
@RestController
@RequestMapping("goodsCollect")
public class GoodsCollectVO {
	/**
	 * 菜品购物车应用流程对象
	 */
    @Autowired
	private  GoodsCollectAO goodsCollectAO;

	@ApiOperation("保存菜品购物车")
	@PostMapping("/save")
	public Result<Long> save(@Valid @RequestBody GoodsCollectReq goodsCollectReq) {
		return goodsCollectAO.insertGoodsCollect(goodsCollectReq);
	}

	@ApiOperation("根据ID删除菜品购物车")
	@GetMapping("/delete")
	public Result<Integer> deleteById(@RequestParam("goodsCollectId")Long goodsCollectId) {
		return goodsCollectAO.deleteById(goodsCollectId);
	}

	@ApiOperation("根据ID查询菜品购物车")
	@RequestMapping(value ="queryById")
	public Result<GoodsCollectDO > queryById(@RequestParam("goodsCollectId")Long goodsCollectId) {
		return goodsCollectAO.queryById(goodsCollectId);
	}

	@ApiOperation("查询菜品购物车")
	@PostMapping("/queryPage")
	public PageResult<GoodsCollect> queryPage(GoodsCollectQuery query) {
		return goodsCollectAO.queryPage( query);
	}

	@ApiOperation("更新菜品购物车")
	@PostMapping("/update")
	public Result<Integer> update( @RequestBody GoodsCollectReq goodsCollectReq) {
		return goodsCollectAO.updateGoodsCollect(goodsCollectReq);
	}

	@ApiOperation("查询集合菜品购物车")
	@PostMapping("/queryList")
	public Result<List<GoodsCollectDO >> queryList(@Valid @RequestBody GoodsCollectQuery query) {
		return goodsCollectAO.queryList(query);
	}

	@GetMapping("/changeDeleted")
	public Result<Integer> changeDeleted(@RequestParam("goodsCollectIds")String goodsCollectIds) {
		List<Long> list = new ArrayList<>();
		if (StringUtils.isNoneBlank(goodsCollectIds))
			list =  Arrays.stream(goodsCollectIds.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
		return goodsCollectAO.changeDeleted(list);
	}

}
