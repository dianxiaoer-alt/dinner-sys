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
 *  店铺使用套餐接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类ShopMealReq 店铺使用套餐")
public class ShopMealReq {
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopMeal.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  套餐名称;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "套餐名称", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shopMeal.meal_title.notEmpty.message}")
	@Length(max = 100, message = "{com.dinner.shopMeal.meal_title.maxLength.message}")
    private String meal_title;
	/**
	 * <pre>
	 *  套餐描述;字段长度:500,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "套餐描述", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shopMeal.meal_desc.notEmpty.message}")
	@Length(max = 500, message = "{com.dinner.shopMeal.meal_desc.maxLength.message}")
    private String meal_desc;
	/**
	 * <pre>
	 *  套餐照片;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "套餐照片", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.shopMeal.meal_img.maxLength.message}")
    private String meal_img;
	/**
	 * <pre>
	 *  套餐价格;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "套餐价格", example = "1.00", dataType = "Double")
	@NotNull(message = "{com.dinner.shopMeal.meal_price.notNoll.message}")
    private Double meal_price;
	/**
	 * <pre>
	 *  ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
    private Integer is_deleted;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
