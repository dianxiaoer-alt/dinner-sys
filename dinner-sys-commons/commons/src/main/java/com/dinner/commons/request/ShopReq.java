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
@ApiModel(description = "请求实体类ShopReq ")
public class ShopReq {
	/**
	 * <pre>
	 *  ;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.shop.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:32,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shop.shop_name.notEmpty.message}")
	@Length(max = 32, message = "{com.dinner.shop.shop_name.maxLength.message}")
    private String shop_name;
	/**
	 * <pre>
	 *  店铺头像;字段长度:300,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "店铺头像", example = "测试", dataType = "String")
	@Length(max = 300, message = "{com.dinner.shop.head_img_url.maxLength.message}")
    private String head_img_url;
	/**
	 * <pre>
	 *  ;字段长度:32,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shop.shop_email.notEmpty.message}")
	@Length(max = 32, message = "{com.dinner.shop.shop_email.maxLength.message}")
    private String shop_email;

	@NotEmpty(message = "{com.dinner.shop.shop_email.notEmpty.message}")
	private String shop_user_name;

	@NotEmpty(message = "{com.dinner.shop.shop_email.notEmpty.message}")
	private String shop_user_code;
	/**
	 * <pre>
	 *  店铺电话;字段长度:32,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "店铺电话", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shop.shop_tel.notEmpty.message}")
	@Length(max = 32, message = "{com.dinner.shop.shop_tel.maxLength.message}")
    private String shop_tel;
	/**
	 * <pre>
	 *  ;字段长度:300,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.shop.shop_password.notEmpty.message}")
	@Length(max = 300, message = "{com.dinner.shop.shop_password.maxLength.message}")
    private String shop_password;
	/**
	 * <pre>
	 *  公众号APPID;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "公众号APPID", example = "测试", dataType = "String")
	@Length(max = 200, message = "{com.dinner.shop.app_id.maxLength.message}")
    private String app_id;
	/**
	 * <pre>
	 *  公众号AppSecret;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "公众号AppSecret", example = "测试", dataType = "String")
	@Length(max = 200, message = "{com.dinner.shop.app_secret.maxLength.message}")
    private String app_secret;
	/**
	 * <pre>
	 *  商户号;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "商户号", example = "测试", dataType = "String")
	@Length(max = 200, message = "{com.dinner.shop.mch_id.maxLength.message}")
    private String mch_id;
	/**
	 * <pre>
	 *  商户支付密码;字段长度:200,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "商户支付密码", example = "测试", dataType = "String")
	@Length(max = 200, message = "{com.dinner.shop.pay_key.maxLength.message}")
    private String pay_key;
	/**
	 * <pre>
	 *  ;字段长度:32,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@Length(max = 32, message = "{com.dinner.shop.last_login_ip.maxLength.message}")
    private String last_login_ip;
	/**
	 * <pre>
	 *  ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
    private Integer is_deleted;
	/**
	 * <pre>
	 *  0没有通过认证，1已通过认证;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "0没有通过认证，1已通过认证", example = "1", dataType = "Integer")
    private Integer is_confirm;
	/**
	 * <pre>
	 *  是否在缴费使用期是否正常使用；0不能使用，1能使用;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "是否在缴费使用期是否正常使用；0不能使用，1能使用", example = "1", dataType = "Integer")
    private Integer is_on;
	/**
	 * <pre>
	 *  使用期限开始日期;字段长度:,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "使用期限开始日期", example = "2020-04-05 11:17:12", dataType = "Date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date use_start_time;
	/**
	 * <pre>
	 *  使用期限结束日期;字段长度:,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "使用期限结束日期", example = "2020-04-05 11:17:12", dataType = "Date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date use_end_time;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
