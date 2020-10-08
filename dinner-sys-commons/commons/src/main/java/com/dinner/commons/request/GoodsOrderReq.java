/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.request;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *  用户订单接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类GoodsOrderReq 用户订单")
public class GoodsOrderReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goodsOrder.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  用户id;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "用户id", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goodsOrder.user_id.notNoll.message}")
    private Long user_id;

	@ApiModelProperty(value = "商家id", example = "1000", dataType = "Long")
	@NotNull(message = "商家id不能为空")
	private Long shop_id;
	/**
	 * <pre>
	 *  餐桌号;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "餐桌号", example = "测试", dataType = "String")
	@Length(max = 32, message = "{com.dinner.goodsOrder.table_num.maxLength.message}")
    private String table_num;
	/**
	 * <pre>
	 *  订单编号;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "订单编号", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.goodsOrder.order_num.notEmpty.message}")
	@Length(max = 100, message = "{com.dinner.goodsOrder.order_num.maxLength.message}")
    private String order_num;
	/**
	 * <pre>
	 *  订单总价格;字段长度:10,0,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "订单总价格", example = "1.00", dataType = "Double")
    private Double order_price;
	/**
	 * <pre>
	 *  0 is not deleted;1 is deleted;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "0 is not deleted;1 is deleted;", example = "1", dataType = "Integer")
    private Integer is_deleted;
	/**
	 * <pre>
	 *  支付状态：0 is not pay;1 is payed;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "支付状态：0 is not pay;1 is payed;", example = "1", dataType = "Integer")
    private Integer is_payed;
	/**
	 * <pre>
	 *  支付时间;字段长度:,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "支付时间", example = "2020-04-05 11:17:12", dataType = "Date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pay_time;
	/**
	 * <pre>
	 *  支付方式：1微信支付，2支付宝;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "支付方式：1微信支付，2支付宝", example = "1", dataType = "Integer")
    private Integer pay_type;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
