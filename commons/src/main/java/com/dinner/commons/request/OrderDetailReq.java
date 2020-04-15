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
 *  订单详情接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类OrderDetailReq 订单详情")
public class OrderDetailReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.orderDetail.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.orderDetail.order_id.notNoll.message}")
    private Long order_id;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.orderDetail.goods_id.notNoll.message}")
    private Long goods_id;
	/**
	 * <pre>
	 *  ;字段长度:4,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
	@NotNull(message = "{com.dinner.orderDetail.goods_count.notNoll.message}")
    private Integer goods_count;
	/**
	 * <pre>
	 *  总价格  商品价格*商品数量;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "总价格  商品价格*商品数量", example = "1.00", dataType = "Double")
	@NotNull(message = "{com.dinner.orderDetail.goods_sum_price.notNoll.message}")
    private Double goods_sum_price;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
