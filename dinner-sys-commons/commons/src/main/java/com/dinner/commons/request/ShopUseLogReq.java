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
@ApiModel(description = "请求实体类ShopUseLogReq ")
public class ShopUseLogReq {
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shopUseLog.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
    private Long shop_id;
	/**
	 * <pre>
	 *  使用开始日期;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "使用开始日期", example = "2020-04-05 11:17:12", dataType = "Date")
	@NotNull(message = "{com.dinner.shopUseLog.use_start_time.notNoll.message}")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date use_start_time;
	/**
	 * <pre>
	 *  ;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "2020-04-05 11:17:12", dataType = "Date")
	@NotNull(message = "{com.dinner.shopUseLog.use_end_time.notNoll.message}")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date use_end_time;

	private Long shop_meal_id;
	private Integer is_using;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
