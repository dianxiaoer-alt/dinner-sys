/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.vo;



import com.dinner.commons.domain.ShopDetail;
import com.dinner.commons.query.ShopDetailQuery;
import com.dinner.commons.request.ShopDetailReq;
import com.dinner.commons.result.Result;
import com.dinner.shop.ao.ShopDetailAO;
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
@Api(tags = "店铺详情，营业执照信息")
@RestController
@RequestMapping("shopDetail")
public class ShopDetailVO {
	/**
	 * 应用流程对象
	 */
    @Autowired
	private final ShopDetailAO shopDetailAO;
	

	public ShopDetailVO(ShopDetailAO shopDetailAO) {
		this.shopDetailAO = shopDetailAO;
	}
	
	@ApiOperation("保存")
	//@PostMapping("save")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@RequestBody ShopDetailReq shopDetailReq) {
		return shopDetailAO.insertShopDetail(shopDetailReq);
	}

	@ApiOperation("根据ID删除")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("shopDetailId")Long shopDetailId) {
		return shopDetailAO.deleteById(shopDetailId);
	}

	@ApiOperation("根据ID查询")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<ShopDetail> queryById(@RequestParam("shopDetailId") Long shopDetailId) {
		return shopDetailAO.queryById(shopDetailId);
	}



	@ApiOperation("更新")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody  ShopDetailReq shopDetailReq) {
		return shopDetailAO.updateShopDetail(shopDetailReq);
	}

	@ApiOperation("查询集合")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<ShopDetail>> queryList(@RequestBody ShopDetailQuery query) {
		return shopDetailAO.queryList(query);
	}

}
