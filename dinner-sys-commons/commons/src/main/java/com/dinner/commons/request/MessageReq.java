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
@ApiModel(description = "请求实体类MessageReq ")
public class MessageReq {
	/**
	 * <pre>
	 *  ;字段长度:20,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.message.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.message.shop_id.notNoll.message}")
    private Long shop_id;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.message.title.notEmpty.message}")
	@Length(max = 100, message = "{com.dinner.message.title.maxLength.message}")
    private String title;
	/**
	 * <pre>
	 *  ;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.message.content.notEmpty.message}")
    private String content;
	/**
	 * <pre>
	 *  ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
    private Integer is_deleted;
	/**
	 * <pre>
	 *  0 未读，1已读;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "0 未读，1已读", example = "1", dataType = "Integer")
    private Integer is_readed;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
