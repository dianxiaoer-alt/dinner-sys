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
@ApiModel(description = "请求实体类ShopDetailReq ")
public class ShopDetailReq {
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopDetail.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopDetail.shop_id.notNoll.message}")
    private Long shop_id;
	/**
	 * <pre>
	 *  身份证正面照片;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "身份证正面照片", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.shopDetail.code_face.maxLength.message}")
    private String code_face;
	/**
	 * <pre>
	 *  身份证反面照片;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "身份证反面照片", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.shopDetail.code_back.maxLength.message}")
    private String code_back;
	/**
	 * <pre>
	 *  营业执照照片;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "营业执照照片", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.shopDetail.deal_img.maxLength.message}")
    private String deal_img;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
