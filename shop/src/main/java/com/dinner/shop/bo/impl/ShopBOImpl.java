/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.bo.impl;



import com.dinner.commons.domain.Shop;
import com.dinner.shop.bo.ShopBO;
import com.dinner.shop.dal.ShopDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <pre>
 * 业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopBO")
public class ShopBOImpl implements ShopBO {
	/**
	 *数据操作对象
	 */
    @Autowired
	private ShopDO shopDAL;


	@Override
	public int insertShop(Shop shop) {
		return shopDAL.insertShop(shop);
	}

	@Override
	public int deleteById(Long shopId) {
		return shopDAL.deleteById(shopId);
	}

	@Override
	public Shop queryById(Long shopId) {
		return shopDAL.queryById(shopId);
	}

	@Override
	public PageInfo<Shop> queryPage(Shop shop,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<>(shopDAL.queryPage(shop));

	}

	@Override
	public int updateShop(Shop shop) {
		return shopDAL.updateShop(shop);
	}

	@Override
	public List<Shop> queryList(Shop shop){
		return shopDAL.queryList(shop);
	}

	@Override
	public Shop shopLoginByTelOrEmail(String value) {
		return shopDAL.shopLoginByTelOrEmail(value);
	}

}
