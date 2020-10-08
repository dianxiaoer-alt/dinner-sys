/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.ao.impl;

import java.util.List;

import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.commons.result.dto.GoodsCollectDO;
import com.dinner.goods.ao.GoodsCollectAO;
import com.dinner.goods.bo.GoodsCollectBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import java.util.List;
/**
 * <pre>
 *   默认 菜品购物车应用实现类，提供菜品购物车相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("goodsCollectAO")
public class DefaultGoodsCollectAO  implements GoodsCollectAO {

    @Autowired
	private final GoodsCollectBO goodsCollectBO;
	

	public DefaultGoodsCollectAO(GoodsCollectBO goodsCollectBO) {
		this.goodsCollectBO = goodsCollectBO;
	}
	
	@Override
	public Result<Long> insertGoodsCollect(GoodsCollectReq goodsCollectReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				GoodsCollect goodsCollect = new GoodsCollect();
				BeanUtils.copyProperties(goodsCollectReq, goodsCollect);
				goodsCollectBO.insertGoodsCollect(goodsCollect);
				resp = Result.success(goodsCollect.getId());
			}
		} catch (Exception e) {
				resp =resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long goodsCollectId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = goodsCollectBO.deleteById(goodsCollectId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}

	@Override
	public Result<GoodsCollectDO > queryById(Long goodsCollectId) {
		Result<GoodsCollectDO > resp = new Result<>();
		try {
			GoodsCollectDO  goodsCollect = goodsCollectBO.queryById(goodsCollectId);
		    resp = Result.success(goodsCollect);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}

	@Override
	public PageResult<GoodsCollect> queryPage(GoodsCollectQuery query) {
		PageResult<GoodsCollect> pr = new PageResult<>();
		try {
			GoodsCollect goodsCollect = new GoodsCollect();
			BeanUtils.copyProperties(query,goodsCollect);
			PageInfo<GoodsCollect> info =  goodsCollectBO.queryPage(goodsCollect,query.getPageNum(),query.getPageSize());
			if(info.getList().isEmpty()){
				return pr.success(null);
			}
			pr.setCurPage(info.getPageNum());
			pr.setTotalItem((int)info.getTotal());
			pr.setPageSize(info.getPageSize());
			pr = pr.success(info.getList());

		} catch (Exception e) {
			pr = pr.error(1,ResultCodeEnum.FAIL.getMsg());
		}
		return pr;
	}

	@Override
	public Result<Integer> updateGoodsCollect(GoodsCollectReq goodsCollectReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				GoodsCollect goodsCollect = new GoodsCollect();
				BeanUtils.copyProperties(goodsCollectReq, goodsCollect);
				int flag = goodsCollectBO.updateGoodsCollect(goodsCollect);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
				resp = resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}
	@Override
	public	Result<List<GoodsCollectDO >> queryList(GoodsCollectQuery query){
		Result<List<GoodsCollectDO >> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				GoodsCollect goodsCollect = new GoodsCollect();
				BeanUtils.copyProperties(query, goodsCollect);
				List<GoodsCollectDO > list = goodsCollectBO.queryList(goodsCollect);
				resp = Result.success(list);
			}
		} catch (Exception e) {
				resp = resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}

	@Override
	public Result<Integer> changeDeleted(List<Long> idList) {
		Result<Integer> resp = new Result<>();
		try {
			if (idList.size() == 0)
				return Result.error(1,"id不能为空");
			int flag = goodsCollectBO.changeDeleted(idList);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL);
		}
		return resp;
	}




}
