/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.app.wx.vo;

import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.feign.GoodsCollectFeignAO;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;

import com.dinner.commons.result.dto.GoodsCollectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


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
@RestController
@RequestMapping("goodsCollect")
public class GoodsCollectVO {
	/**
	 * 菜品购物车应用流程对象
	 */
    @Autowired
	private GoodsCollectFeignAO goodsCollectFeignAO;

	@UserPassToken
	@PostMapping("/save")
	public Result<Long> save(@Valid @RequestBody GoodsCollectReq goodsCollectReq) {
		return goodsCollectFeignAO.save(goodsCollectReq);
	}

	@UserPassToken
	@GetMapping("/delete")
	public Result<Integer> deleteById(@RequestParam("goodsCollectId")Long goodsCollectId) {
		return goodsCollectFeignAO.deleteById(goodsCollectId);
	}

	@UserPassToken
	@GetMapping("/queryById")
	public Result<GoodsCollectDTO> queryById(@RequestParam("goodsCollectId")Long goodsCollectId) {
		return goodsCollectFeignAO.queryById(goodsCollectId);
	}

	@UserPassToken
	@PostMapping("/update")
	public Result<Integer> update( @RequestBody GoodsCollectReq goodsCollectReq) {
		return goodsCollectFeignAO.update(goodsCollectReq);
	}

	@UserPassToken
	@PostMapping("/queryList")
	public Result<List<GoodsCollectDTO>> queryList(@Valid @RequestBody GoodsCollectQuery query, HttpServletRequest request) {
		query.setShop_id(Long.parseLong(request.getHeader("shopId")));
		query.setUser_id(Long.parseLong(String.valueOf(request.getAttribute("userId"))));
		return goodsCollectFeignAO.queryList(query);
	}

	//删除购物车
	@UserPassToken
	@GetMapping("/changeDeleted")
	public Result<Integer> changeDeleted(@RequestParam("goodsCollectIds")String goodsCollectIds){
		return goodsCollectFeignAO.changeDeleted(goodsCollectIds);
	}
}
