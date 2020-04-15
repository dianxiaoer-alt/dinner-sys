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
 *	<b>表名</b>：goods_order
 *  用户订单，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("用户订单")
public class GoodsOrder extends Base implements Serializable {
	private static final long serialVersionUID = 5377042525573998382L;
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
	 * 数据库字段: user_id
	 * 描述: 用户id;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("用户id")
    private Long user_id;
	/**
	 * <pre>
	 * 数据库字段: table_num
	 * 描述: 餐桌号;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("餐桌号")
    private String table_num;
	/**
	 * <pre>
	 * 数据库字段: order_num
	 * 描述: 订单编号;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("订单编号")
    private String order_num;
	/**
	 * <pre>
	 * 数据库字段: order_price
	 * 描述: 订单总价格;字段长度:10,0,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("订单总价格")
    private Double order_price;
	/**
	 * <pre>
	 * 数据库字段: is_deleted
	 * 描述: 0 is not deleted;1 is deleted;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("0 is not deleted;1 is deleted;")
    private Integer is_deleted;
	/**
	 * <pre>
	 * 数据库字段: is_payed
	 * 描述: 支付状态：0 is not pay;1 is payed;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("支付状态：0 is not pay;1 is payed;")
    private Integer is_payed;
	/**
	 * <pre>
	 * 数据库字段: pay_time
	 * 描述: 支付时间;字段长度:,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("支付时间")
    private Date pay_time;
	/**
	 * <pre>
	 * 数据库字段: pay_type
	 * 描述: 支付方式：1微信支付，2支付宝;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("支付方式：1微信支付，2支付宝")
    private Integer pay_type;

	private String nick_name;


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
