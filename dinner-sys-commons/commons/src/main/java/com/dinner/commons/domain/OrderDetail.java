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
 *	<b>表名</b>：order_detail
 *  订单详情，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("订单详情")
public class OrderDetail extends Base implements Serializable {
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
	 * 数据库字段: order_id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Long order_id;
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
	 * 数据库字段: goods_count
	 * 描述: ;字段长度:4,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Integer goods_count;
	/**
	 * <pre>
	 * 数据库字段: goods_sum_price
	 * 描述: 总价格  商品价格*商品数量;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("总价格  商品价格*商品数量")
    private Double goods_sum_price;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
