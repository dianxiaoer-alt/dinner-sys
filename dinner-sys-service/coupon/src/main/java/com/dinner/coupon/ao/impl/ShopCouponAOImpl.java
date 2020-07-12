/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.coupon.ao.impl;

import com.dinner.commons.domain.ShopCoupon;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopCouponQuery;
import com.dinner.commons.request.ShopCouponReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.coupon.ao.ShopCouponAO;
import com.dinner.coupon.bo.ShopCouponBO;
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
@Service("shopCouponAO")
public class ShopCouponAOImpl implements ShopCouponAO {
	/**
	 * 业务操作对象
	 */
    @Autowired
	private ShopCouponBO shopCouponManager;
	

	@Override
	public Result<Long> insertShopCoupon(ShopCouponReq shopCouponReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopCoupon shopCoupon = new ShopCoupon();
				BeanUtils.copyProperties(shopCouponReq, shopCoupon);
				shopCouponManager.insertShopCoupon(shopCoupon);
				resp = Result.success(shopCoupon.getId());
			}
		} catch (Exception e) {
				resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long shopCouponId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = shopCouponManager.deleteById(shopCouponId);
			resp = Result.success(flag);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<ShopCoupon> queryById(Long shopCouponId) {
		Result<ShopCoupon> resp = new Result<>();
		try {
			ShopCoupon shopCoupon = shopCouponManager.queryById(shopCouponId);
		    resp = Result.success(shopCoupon);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public PageResult<ShopCoupon> queryPage(Page page, ShopCouponQuery query) {
		PageResult<ShopCoupon> pr = new PageResult<>();
		try {
			ShopCoupon shopCoupon = new ShopCoupon();
			BeanUtils.copyProperties(query,shopCoupon);
			List<ShopCoupon> list = shopCouponManager.queryPage(page, shopCoupon);
			pr = pr.success(list);
			pr.setCurPage(page.getCurPage());
			pr.setTotalItem(page.getTotalItem());
			pr.setPageSize(page.getPageSize());
		} catch (Exception e) {
			pr = pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return pr;
	}

	@Override
	public Result<Integer> updateShopCoupon(ShopCouponReq shopCouponReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopCoupon shopCoupon = new ShopCoupon();
				BeanUtils.copyProperties(shopCouponReq, shopCoupon);
				int flag = shopCouponManager.updateShopCoupon(shopCoupon);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<ShopCoupon>> queryList( ShopCouponQuery query){
		Result<List<ShopCoupon>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				ShopCoupon shopCoupon = new ShopCoupon();
				BeanUtils.copyProperties(query, shopCoupon);
				List<ShopCoupon> list = shopCouponManager.queryList(shopCoupon);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
