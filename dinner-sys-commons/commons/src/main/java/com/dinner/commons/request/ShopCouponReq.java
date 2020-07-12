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
 *  接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类ShopCouponReq ")
public class ShopCouponReq {
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopCoupon.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopCoupon.shop_id.notNoll.message}")
    private Long shop_id;
	/**
	 * <pre>
	 *  优惠券价格;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "优惠券价格", example = "1.00", dataType = "Double")
	@NotNull(message = "{com.dinner.shopCoupon.price.notNoll.message}")
    private Double price;
	/**
	 * <pre>
	 *  ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
    private Integer is_deleted;
	/**
	 * <pre>
	 *  优惠券个数;字段长度:4,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "优惠券个数", example = "1", dataType = "Integer")
	@NotNull(message = "{com.dinner.shopCoupon.sum.notNoll.message}")
    private Integer sum;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
