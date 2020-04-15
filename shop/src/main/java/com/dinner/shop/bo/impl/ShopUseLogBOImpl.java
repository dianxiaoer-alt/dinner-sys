/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.bo.impl;


import java.util.List;

import com.dinner.shop.bo.ShopUseLogBO;
import com.dinner.shop.dal.ShopUseLogDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinner.commons.domain.ShopUseLog;

/**
 * <pre>
 * 业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopUseLogBO")
public class ShopUseLogBOImpl implements ShopUseLogBO {
	/**
	 *数据操作对象
	 */
    @Autowired
	private ShopUseLogDO shopUseLogDAL;
	

	@Override
	public int insertShopUseLog(ShopUseLog shopUseLog) {
		return shopUseLogDAL.insertShopUseLog(shopUseLog);
	}

	@Override
	public int deleteById(Long shopUseLogId) {
		return shopUseLogDAL.deleteById(shopUseLogId);
	}

	@Override
	public ShopUseLog queryById(Long shopUseLogId) {
		return shopUseLogDAL.queryById(shopUseLogId);
	}

	@Override
	public PageInfo<ShopUseLog> queryPage( ShopUseLog shopUseLog,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<ShopUseLog>(shopUseLogDAL.queryPage(shopUseLog)) ;

	}

	@Override
	public int updateShopUseLog(ShopUseLog shopUseLog) {
		return shopUseLogDAL.updateShopUseLog(shopUseLog);
	}

	@Override
	public List<ShopUseLog> queryList(ShopUseLog shopUseLog){
		return shopUseLogDAL.queryList(shopUseLog);
	}

}
