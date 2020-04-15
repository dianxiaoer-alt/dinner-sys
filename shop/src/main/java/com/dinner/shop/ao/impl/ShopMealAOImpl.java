/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.ao.impl;

import com.dinner.commons.domain.ShopMeal;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopMealQuery;
import com.dinner.commons.request.ShopMealReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.shop.ao.ShopMealAO;
import com.dinner.shop.bo.ShopMealBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <pre>
 *   默认 店铺使用套餐应用实现类，提供店铺使用套餐相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("shopMealAO")
public class ShopMealAOImpl  implements ShopMealAO {
	/**
	 * 店铺使用套餐业务操作对象
	 */
    @Autowired
	private ShopMealBO shopMealManager;
	


	@Override
	public Result<Long> insertShopMeal(ShopMealReq shopMealReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopMeal shopMeal = new ShopMeal();
				BeanUtils.copyProperties(shopMealReq, shopMeal);
				shopMealManager.insertShopMeal(shopMeal);
				resp = Result.success(shopMeal.getId());
			}
		} catch (Exception e) {
			resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long shopMealId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = shopMealManager.deleteById(shopMealId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<ShopMeal> queryById(Long shopMealId) {
		Result<ShopMeal> resp = new Result<>();
		try {
			ShopMeal shopMeal = shopMealManager.queryById(shopMealId);
		    resp = Result.success(shopMeal);
		} catch (Exception e) {
			resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}



	@Override
	public Result<Integer> updateShopMeal(ShopMealReq shopMealReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopMeal shopMeal = new ShopMeal();
				BeanUtils.copyProperties(shopMealReq, shopMeal);
				int flag = shopMealManager.updateShopMeal(shopMeal);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
				resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<ShopMeal>> queryList( ShopMealQuery query){
		Result<List<ShopMeal>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopMeal shopMeal = new ShopMeal();
				BeanUtils.copyProperties(query, shopMeal);
				List<ShopMeal> list = shopMealManager.queryList(shopMeal);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
