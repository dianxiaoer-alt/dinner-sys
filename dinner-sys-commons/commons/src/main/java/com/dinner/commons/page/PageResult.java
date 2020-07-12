/*
 * Copyright 2017 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.page;



import com.dinner.commons.BaseResult;
import com.dinner.commons.result.ResultCodeEnum;

import java.util.List;

/**
 * <pre>
 * 分页结果对象
 * </pre>
 *
 * @author jiankang.xia@bees360.com
 * @Date 2019
 * @since 1.0
 */
public class PageResult<T>  extends BaseResult {


	public PageResult(){}

	/**
	 * 0常量
	 */
	private static final int ZERO = 0;
	/**
	 * 1常量
	 */
	private static final int ONE = 1;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 当前页数
	 */
	private Integer curPage;
	/**
	 * 数据库总记录数
	 */
	private int totalItem;
	/**
	 * 返回的数据信息
	 */
	private List<T> data;

	public PageResult(Integer code, String msg) {
		super.setCode(code);
		super.setMsg(msg);
	}


	public PageResult(List<T> data) {
		setCode(ResultCodeEnum.SUCCESS.getCode());
		setMsg(ResultCodeEnum.SUCCESS.getMsg());
		this.data = data;
	}

	public PageResult(ResultCodeEnum resultCodeEnum){
		if(resultCodeEnum != null){
			setCode(resultCodeEnum.getCode());
			setMsg( resultCodeEnum.getMsg());
		}
	}


	/**
	 * <p>
	 * 获取总页数
	 * </p>
	 * 
	 * @return 总页数数量
	 */
	public int getTotalPage() {
		if (totalItem == ZERO || pageSize == ZERO) {
			return ZERO;
		} else {
			int orgPage = this.totalItem / this.pageSize;
			return (this.totalItem % this.pageSize == ZERO ? orgPage : orgPage + ONE);
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 *  失败时候的调用
	 * */
	public static  <T> PageResult<T> error(Integer code, String msg){
		return new PageResult<T>(code, msg);
	}

	/**
	 *  成功时候的调用
	 * */
	public static  <T> PageResult<T> success(List<T> data){
		return new PageResult<T>(data);
	}



}
