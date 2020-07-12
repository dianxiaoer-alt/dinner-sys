/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.ao.impl;

import java.util.List;


import com.dinner.commons.domain.ShopDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopDetailQuery;
import com.dinner.commons.request.ShopDetailReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.shop.ao.ShopDetailAO;
import com.dinner.shop.bo.ShopDetailBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *   默认 应用实现类，提供相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopDetailAO")
public class ShopDetailAOImpl implements ShopDetailAO {
	/**
	 * 业务操作对象
	 */
    @Autowired
	private ShopDetailBO shopDetailManager;
	

	@Override
	public Result<Long> insertShopDetail(ShopDetailReq shopDetailReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopDetail shopDetail = new ShopDetail();
				BeanUtils.copyProperties(shopDetailReq, shopDetail);
				shopDetailManager.insertShopDetail(shopDetail);
				resp = Result.success(shopDetail.getId());
			}
		} catch (Exception e) {
				resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long shopDetailId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = shopDetailManager.deleteById(shopDetailId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<ShopDetail> queryById(Long shopDetailId) {
		Result<ShopDetail> resp = new Result<>();
		try {
			ShopDetail shopDetail = shopDetailManager.queryById(shopDetailId);
		    resp = Result.success(shopDetail);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


	@Override
	public Result<Integer> updateShopDetail(ShopDetailReq shopDetailReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopDetail shopDetail = new ShopDetail();
				BeanUtils.copyProperties(shopDetailReq, shopDetail);
				int flag = shopDetailManager.updateShopDetail(shopDetail);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<ShopDetail>> queryList( ShopDetailQuery query){
		Result<List<ShopDetail>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopDetail shopDetail = new ShopDetail();
				BeanUtils.copyProperties(query, shopDetail);
				List<ShopDetail> list = shopDetailManager.queryList(shopDetail);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
