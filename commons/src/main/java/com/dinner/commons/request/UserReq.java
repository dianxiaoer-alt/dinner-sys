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
 *  微信登录授权用户表接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类UserReq 微信登录授权用户表")
public class UserReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.user.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  昵称;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "昵称", example = "测试", dataType = "String")
	@Length(max = 32, message = "{com.dinner.user.nick_name.maxLength.message}")
    private String nick_name;
	/**
	 * <pre>
	 *  头像;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "头像", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.user.head_img_url.maxLength.message}")
    private String head_img_url;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.user.open_id.notEmpty.message}")
	@Length(max = 100, message = "{com.dinner.user.open_id.maxLength.message}")
    private String open_id;
	/**
	 * <pre>
	 *  ;字段长度:500,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.user.access_token.notEmpty.message}")
	@Length(max = 500, message = "{com.dinner.user.access_token.maxLength.message}")
    private String access_token;
	/**
	 * <pre>
	 *  用户信息系列化;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "用户信息系列化", example = "测试", dataType = "String")
	@Length(max = 500, message = "{com.dinner.user.profile.maxLength.message}")
    private String profile;
	/**
	 * <pre>
	 *  电话号码;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "电话号码", example = "测试", dataType = "String")
	@Length(max = 32, message = "{com.dinner.user.number.maxLength.message}")
    private String number;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
