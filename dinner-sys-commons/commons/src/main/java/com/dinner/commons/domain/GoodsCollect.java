/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.domain;

import java.util.Date;

import com.dinner.commons.domain.base.Base;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *	<b>表名</b>：goods_collect
 *  菜品购物车，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("菜品购物车")
public class GoodsCollect extends Base {
	/**
	 * <pre>
	 * 数据库字段: id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long id;
	/**
	 * <pre>
	 * 数据库字段: goods_id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long goods_id;
	/**
	 * <pre>
	 * 数据库字段: goods_num
	 * 描述: ;字段长度:4,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Integer goods_num;
	/**
	 * <pre>
	 * 数据库字段: user_id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long user_id;
	/**
	 * <pre>
	 * 数据库字段: shop_id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long shop_id;
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
