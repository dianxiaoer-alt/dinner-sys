/*
 * Copyright 2018 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.page;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * <pre>
 * 分页信息对象
 * </pre>
 * 
 * @author jiankang.xia@bees360.com
 * @Date 2019
 * @since 1.0
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 5377042525573998382L;
	/**
	 * 每页最大记录数默认是 1 万，防止恶意刷库导致数据库堵塞
	 */
	private static final int MAX_SIZE = 10000;
	/**
	 * 默认当前页
	 */
	private static final int CURPAGE = 1;
	/**
	 * 每页默认记录
	 */
	private static final int DEFAULT = 10;
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
	@JsonIgnore
	private int totalItem;

	/**
	 * <p>
	 * 缺省构造函数,默认是每页10条记录
	 * </p>
	 */
	public Page() {
		this(CURPAGE, DEFAULT);
	}

	/**
	 * <p>
	 * 每页记录构造函数
	 * </p>
	 * 
	 * @param pageSize 每页记录
	 */
	public Page(Integer pageSize) {
		this(CURPAGE, pageSize);
	}

	/**
	 * <p>
	 * 根据当前页和每页记录创建对象
	 * </p>
	 * 
	 * @param curPage 当前页
	 * @param pageSize    每页记录数
	 */
	public Page(Integer curPage, Integer pageSize) {
		if (pageSize == null) {
			this.pageSize = DEFAULT;
		} else if (pageSize > MAX_SIZE) {
			this.pageSize = MAX_SIZE;
		} else {
			this.pageSize = pageSize.intValue();
		}
		this.curPage = ((curPage == null || curPage.intValue() < 1) ? 1 : curPage.intValue());
	}

	/**
	 * <p>
	 * 获取开始记录数
	 * </p>
	 * 
	 * @return 查询开始数据行
	 */
	@JsonIgnore
	public int getStartRow() {
		if (this.totalItem == 0) {
			return 0;
		} else {
			return ((this.curPage - 1) * this.pageSize);
		}
	}

	/**
	 * <p>
	 * 获取结束数据数
	 * </p>
	 * 
	 * @return 结束的数据行
	 */
	@JsonIgnore
	public int getEndRow() {
		if (this.totalItem == 0) {
			return 0;
		} else {
			return (this.getStartRow() + getPageSize());
		}
	}

	/**
	 * <p>
	 * 获取每页记录数
	 * </p>
	 * 
	 * @return 每页记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * <p>
	 * 设置每页数量，
	 * </p>
	 * 
	 * @param pageSize 每页数量
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = (pageSize > MAX_SIZE ? MAX_SIZE : pageSize);
	}

	/**
	 * <p>
	 * 当前页数,因为这个数字是页面赋值的,很可能不是正确的数字,所以这里判断
	 * </p>
	 * 
	 * @return 当前页
	 */
	public Integer getCurPage() {
		if (getTotalPage() == 0) {
			return 1;
		} else {
			return curPage > getTotalPage() ? getTotalPage() : curPage;
		}
	}

	/**
	 * <p>
	 * 返回当前页数
	 * </p>
	 * 
	 * @param curPage 当前页
	 */
	public void setCurPage(Integer curPage) {
		this.curPage = (curPage == null || curPage <= 0) ? 1 : curPage;
	}

	/**
	 * <p>
	 * 获取数据总记录
	 * </p>
	 * 
	 * @return 分页总记录数
	 */
	@JsonIgnore
	public int getTotalItem() {
		return this.totalItem;
	}

	/**
	 * <p>
	 * 设置数据总记录
	 * </p>
	 * 
	 * @param totalItem 查询数量总记录
	 */
	@JsonIgnore
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	/**
	 * <p>
	 * 获取总页数
	 * </p>
	 * 
	 * @return 总页数数量
	 */
	@JsonIgnore
	public int getTotalPage() {
		int orgPage = this.totalItem / this.pageSize;
		return (this.totalItem % this.pageSize == 0 ? orgPage : orgPage + 1);
	}

}
