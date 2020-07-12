/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.bo.impl;

import java.util.Collections;
import java.util.List;

import com.dinner.commons.domain.ShopMeal;
import com.dinner.shop.bo.ShopMealBO;
import com.dinner.shop.dal.ShopMealDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 店铺使用套餐业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopMealBO")
public class ShopMealBOImpl implements ShopMealBO {
	/**
	 *店铺使用套餐数据操作对象
	 */
    @Autowired
	private  ShopMealDO shopMealDAL;
	

	@Override
	public int insertShopMeal(ShopMeal shopMeal) {
		return shopMealDAL.insertShopMeal(shopMeal);
	}

	@Override
	public int deleteById(Long shopMealId) {
		return shopMealDAL.deleteById(shopMealId);
	}

	@Override
	public ShopMeal queryById(Long shopMealId) {
		return shopMealDAL.queryById(shopMealId);
	}


	@Override
	public int updateShopMeal(ShopMeal shopMeal) {
		return shopMealDAL.updateShopMeal(shopMeal);
	}

	@Override
	public List<ShopMeal> queryList(ShopMeal shopMeal){
		return shopMealDAL.queryList(shopMeal);
	}

}
