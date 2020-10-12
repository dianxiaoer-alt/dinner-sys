/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.bo.impl;

import java.util.List;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.result.dto.GoodsCollectDTO;
import com.dinner.goods.dal.GoodsCollectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dinner.goods.bo.GoodsCollectBO;

/**
 * <pre>
 * 菜品购物车业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("goodsCollectBO")
public class DefaultGoodsCollectBO implements GoodsCollectBO {
	/**
	 *菜品购物车数据操作对象
	 */
    @Autowired
	private final GoodsCollectDAO goodsCollectDAO;
	

	public DefaultGoodsCollectBO(GoodsCollectDAO goodsCollectDAO) {
		this.goodsCollectDAO = goodsCollectDAO;
	}

	@Override
	public int insertGoodsCollect(GoodsCollect goodsCollect) {
		return goodsCollectDAO.insertGoodsCollect(goodsCollect);
	}

	@Override
	public int deleteById(Long goodsCollectId) {
		return goodsCollectDAO.deleteById(goodsCollectId);
	}

	@Override
	public GoodsCollectDTO queryById(Long goodsCollectId) {
		return goodsCollectDAO.queryById(goodsCollectId);
	}

	@Override
	public PageInfo<GoodsCollect> queryPage(GoodsCollect goodsCollect,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<>(goodsCollectDAO.queryPage(goodsCollect)) ;
	}

	@Override
	public int updateGoodsCollect(GoodsCollect goodsCollect) {
		return goodsCollectDAO.updateGoodsCollect(goodsCollect);
	}

	@Override
	public List<GoodsCollectDTO> queryList(GoodsCollect goodsCollect){
		return goodsCollectDAO.queryList(goodsCollect);
	}

	@Override
	public int changeDeleted(List<Long> idList) {
		return goodsCollectDAO.changeDeleted(idList);
	}

}
