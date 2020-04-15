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
 *  后台管理员用户接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类AdminUserReq 后台管理员用户")
public class AdminUserReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.adminUser.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:32,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.adminUser.username.notEmpty.message}")
	@Length(max = 32, message = "{com.dinner.adminUser.username.maxLength.message}")
    private String username;
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.adminUser.password.notEmpty.message}")
	@Length(max = 200, message = "{com.dinner.adminUser.password.maxLength.message}")
    private String password;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
