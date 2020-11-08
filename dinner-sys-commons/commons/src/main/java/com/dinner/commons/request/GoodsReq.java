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
 *  菜品表接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类GoodsReq 菜品表")
public class GoodsReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  goods's title;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "goods's title", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.goods.goods_title.notEmpty.message}")
	@Length(max = 100, message = "{com.dinner.goods.goods_title.maxLength.message}")
    private String goods_title;
	/**
	 * <pre>
	 *  goods's head img;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "goods's head img", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.goods.goods_head_img.notEmpty.message}")
	@Length(max = 200, message = "{com.dinner.goods.goods_head_img.maxLength.message}")
    private String goods_head_img;
	/**
	 * <pre>
	 *  ;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1.00", dataType = "Double")
	@NotNull(message = "{com.dinner.goods.goods_price.notNoll.message}")
    private Double goods_price;

	/**
	 * <pre>
	 *  market price;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "market price", example = "1.00", dataType = "Double")
	@NotNull(message = "{com.dinner.goods.goods_market_price.notNoll.message}")
    private Double goods_market_price;
	/**
	 * <pre>
	 *  ;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "测试", dataType = "String")
	@NotEmpty(message = "{com.dinner.goods.goods_content.notEmpty.message}")
    private String goods_content;
	/**
	 * <pre>
	 *  goods's type id;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "goods's type id", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goods_type_id.notNoll.message}")
    private Long goods_type_id;
	/**
	 * <pre>
	 *  菜品对应店铺id;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "菜品对应店铺id", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goods_shop_id.notNoll.message}")
    private Long goods_shop_id;
	/**
	 * <pre>
	 *  sell sum ;字段长度:11,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "sell sum ", example = "1", dataType = "Integer")
    private Integer goods_sell_sum;
	/**
	 * <pre>
	 *  0 no deleted;1 is deleted.;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "0 no deleted;1 is deleted.", example = "1", dataType = "Integer")
    private Integer is_deleted;
	/**
	 * <pre>
	 *  0 not on sale;1 is on sale;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "0 not on sale;1 is on sale;", example = "1", dataType = "Integer")
    private Integer is_on_sale;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
