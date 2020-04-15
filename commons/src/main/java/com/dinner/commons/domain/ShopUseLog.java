/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.dinner.commons.domain.base.Base;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *	<b>表名</b>：shop_use_log
 *  ，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("")
public class ShopUseLog extends Base implements Serializable {
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
	 * 数据库字段: shop_id
	 * 描述: ;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long shop_id;
	/**
	 * <pre>
	 * 数据库字段: use_start_time
	 * 描述: 使用开始日期;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("使用开始日期")
    private Date use_start_time;
	/**
	 * <pre>
	 * 数据库字段: use_end_time
	 * 描述: ;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Date use_end_time;

	private Long shop_meal_id;
	private Integer is_using;
	private String shop_name;
	private ShopMeal shop_meal;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
