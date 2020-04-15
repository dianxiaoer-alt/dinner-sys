/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.coupon.bo.impl;

import java.util.Collections;
import java.util.List;

import com.dinner.commons.domain.ShopCoupon;
import com.dinner.commons.page.Page;
import com.dinner.coupon.bo.ShopCouponBO;
import com.dinner.coupon.dal.ShopCouponDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * 业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopCouponBO")
public class ShopCouponBOImpl implements ShopCouponBO {
	/**
	 *数据操作对象
	 */
    @Autowired
	private  ShopCouponDO shopCouponDAL;
	



	@Override
	public int insertShopCoupon(ShopCoupon shopCoupon) {
		return shopCouponDAL.insertShopCoupon(shopCoupon);
	}

	@Override
	public int deleteById(Long shopCouponId) {
		return shopCouponDAL.deleteById(shopCouponId);
	}

	@Override
	public ShopCoupon queryById(Long shopCouponId) {
		return shopCouponDAL.queryById(shopCouponId);
	}

	@Override
	public List<ShopCoupon> queryPage(Page page, ShopCoupon shopCoupon) {
		int count = shopCouponDAL.countPage(shopCoupon);
		if (count == 0) {
			return Collections.emptyList();
		} else {
			page.setTotalItem(count);
			return shopCouponDAL.queryPage(page, shopCoupon);
		}
	}

	@Override
	public int updateShopCoupon(ShopCoupon shopCoupon) {
		return shopCouponDAL.updateShopCoupon(shopCoupon);
	}

	@Override
	public List<ShopCoupon> queryList(ShopCoupon shopCoupon){
		return shopCouponDAL.queryList(shopCoupon);
	}

}
