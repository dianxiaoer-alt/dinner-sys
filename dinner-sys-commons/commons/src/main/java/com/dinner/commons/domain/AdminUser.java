/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.domain;

import com.dinner.commons.domain.base.Base;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * <pre>
 *	<b>表名</b>：admin_user
 *  后台管理员用户，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("后台管理员用户")
public class AdminUser extends Base implements Serializable {
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
	 * 数据库字段: username
	 * 描述: ;字段长度:32,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private String username;
	/**
	 * <pre>
	 * 数据库字段: password
	 * 描述: ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private String password;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
