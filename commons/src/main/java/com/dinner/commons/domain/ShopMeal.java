/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.dinner.commons.domain.base.Base;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *	<b>表名</b>：shop_meal
 *  店铺使用套餐，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("店铺使用套餐")
public class ShopMeal extends Base {
	/**
	 * <pre>
	 * 数据库字段: id
	 * 描述: ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long id;
	/**
	 * <pre>
	 * 数据库字段: meal_title
	 * 描述: 套餐名称;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("套餐名称")
    private String meal_title;
	/**
	 * <pre>
	 * 数据库字段: meal_desc
	 * 描述: 套餐描述;字段长度:500,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("套餐描述")
    private String meal_desc;
	/**
	 * <pre>
	 * 数据库字段: meal_img
	 * 描述: 套餐照片;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("套餐照片")
    private String meal_img;
	/**
	 * <pre>
	 * 数据库字段: meal_price
	 * 描述: 套餐价格;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("套餐价格")
    private Double meal_price;
	/**
	 * <pre>
	 * 数据库字段: is_deleted
	 * 描述: ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Integer is_deleted;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
