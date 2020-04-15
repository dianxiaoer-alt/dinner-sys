/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.shop.ao.impl;

import com.dinner.commons.domain.ShopUseLog;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopUseLogQuery;
import com.dinner.commons.request.ShopUseLogReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.shop.ao.ShopUseLogAO;
import com.dinner.shop.bo.ShopUseLogBO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * <pre>
 *   默认 应用实现类，提供相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("ShopUseLogAO")
public class ShopUseLogAOImpl implements ShopUseLogAO {
	/**
	 * 业务操作对象
	 */
    @Autowired
	private  ShopUseLogBO shopUseLogManager;
	

	@Override
	public Result<Long> insertShopUseLog(ShopUseLogReq shopUseLogReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopUseLog shopUseLog = new ShopUseLog();
				BeanUtils.copyProperties(shopUseLogReq, shopUseLog);
				shopUseLogManager.insertShopUseLog(shopUseLog);
				resp = Result.success(shopUseLog.getId());
			}
		} catch (Exception e) {
				resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long shopUseLogId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = shopUseLogManager.deleteById(shopUseLogId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<ShopUseLog> queryById(Long shopUseLogId) {
		Result<ShopUseLog> resp = new Result<>();
		try {
			ShopUseLog shopUseLog = shopUseLogManager.queryById(shopUseLogId);
		    resp = Result.success(shopUseLog);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


	@Override
	public Result<Integer> updateShopUseLog(ShopUseLogReq shopUseLogReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopUseLog shopUseLog = new ShopUseLog();
				BeanUtils.copyProperties(shopUseLogReq, shopUseLog);
				int flag = shopUseLogManager.updateShopUseLog(shopUseLog);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<ShopUseLog>> queryList( ShopUseLogQuery query){
		Result<List<ShopUseLog>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopUseLog shopUseLog = new ShopUseLog();
				BeanUtils.copyProperties(query, shopUseLog);
				List<ShopUseLog> list = shopUseLogManager.queryList(shopUseLog);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<PageInfo<ShopUseLog>> queryPage(ShopUseLogQuery query) {
		Result<PageInfo<ShopUseLog>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopUseLog shopUseLog = new ShopUseLog();
				BeanUtils.copyProperties(query, shopUseLog);
				PageInfo<ShopUseLog> list = shopUseLogManager.queryPage(shopUseLog,query.getPageNum(),query.getPageSize());
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
