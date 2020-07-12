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
 *	<b>表名</b>：user
 *  微信登录授权用户表，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("微信登录授权用户表")
public class User extends Base implements Serializable {
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
	 * 数据库字段: nick_name
	 * 描述: 昵称;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("昵称")
    private String nick_name;
	/**
	 * <pre>
	 * 数据库字段: head_img_url
	 * 描述: 头像;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("头像")
    private String head_img_url;
	/**
	 * <pre>
	 * 数据库字段: open_id
	 * 描述: ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private String open_id;
	/**
	 * <pre>
	 * 数据库字段: access_token
	 * 描述: ;字段长度:500,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private String access_token;
	/**
	 * <pre>
	 * 数据库字段: profile
	 * 描述: 用户信息系列化;字段长度:500,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("用户信息系列化")
    private String profile;
	/**
	 * <pre>
	 * 数据库字段: number
	 * 描述: 电话号码;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("电话号码")
    private String number;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
