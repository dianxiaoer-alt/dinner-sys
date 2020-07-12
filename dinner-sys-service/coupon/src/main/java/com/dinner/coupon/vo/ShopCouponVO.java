/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.coupon.vo;

import javax.validation.Valid;

import com.dinner.coupon.ao.ShopCouponAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinner.commons.domain.ShopCoupon;
import com.dinner.commons.query.ShopCouponQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.ShopCouponReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "店铺优惠券")
@RestController
@RequestMapping("shopCoupon")
public class ShopCouponVO {
	/**
	 * 应用流程对象
	 */
    @Autowired
	private final ShopCouponAO shopCouponAO;
	

	public ShopCouponVO(ShopCouponAO shopCouponAO) {
		this.shopCouponAO = shopCouponAO;
	}
	
	@ApiOperation("保存")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@Valid @RequestBody ShopCouponReq shopCouponReq) {
		return shopCouponAO.insertShopCoupon(shopCouponReq);
	}

	@ApiOperation("根据ID删除")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("shopCouponId")Long shopCouponId) {
		return shopCouponAO.deleteById(shopCouponId);
	}

	@ApiOperation("根据ID查询")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<ShopCoupon> queryById(@RequestParam("shopCouponId") Long shopCouponId) {
		return shopCouponAO.queryById(shopCouponId);
	}



	@ApiOperation("更新")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody ShopCouponReq shopCouponReq) {
		return shopCouponAO.updateShopCoupon(shopCouponReq);
	}

	@ApiOperation("查询集合")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<ShopCoupon>> queryList(@RequestBody ShopCouponQuery query) {
		return shopCouponAO.queryList(query);
	}

}
