/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.bo.impl;

import java.util.Collections;
import java.util.List;

import com.dinner.commons.domain.ShopDetail;
import com.dinner.shop.bo.ShopDetailBO;
import com.dinner.shop.dal.ShopDetailDO;
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
@Service("ShopDetailBO")
public class ShopDetailBOImpl implements ShopDetailBO {
	/**
	 *数据操作对象
	 */
    @Autowired
	private  ShopDetailDO shopDetailDAL;
	

	@Override
	public int insertShopDetail(ShopDetail shopDetail) {
		return shopDetailDAL.insertShopDetail(shopDetail);
	}

	@Override
	public int deleteById(Long shopDetailId) {
		return shopDetailDAL.deleteById(shopDetailId);
	}

	@Override
	public ShopDetail queryById(Long shopDetailId) {
		return shopDetailDAL.queryById(shopDetailId);
	}

	@Override
	public List<ShopDetail> queryPage(ShopDetail shopDetail) {
		return shopDetailDAL.queryPage(shopDetail);

	}

	@Override
	public int updateShopDetail(ShopDetail shopDetail) {
		return shopDetailDAL.updateShopDetail(shopDetail);
	}

	@Override
	public List<ShopDetail> queryList(ShopDetail shopDetail){
		return shopDetailDAL.queryList(shopDetail);
	}

}
