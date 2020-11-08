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
 *	<b>表名</b>：goods
 *  菜品表，其中一些通用字段在ModelDO和BaseDO里面，该对象基本上只用于数据保存使用。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@Api("菜品表")
public class Goods extends Base implements Serializable {
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
	 * 数据库字段: goods_title
	 * 描述: goods's title;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("goods's title")
    private String goods_title;
	/**
	 * <pre>
	 * 数据库字段: goods_head_img
	 * 描述: goods's head img;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("goods's head img")
    private String goods_head_img;
	/**
	 * <pre>
	 * 数据库字段: goods_price
	 * 描述: ;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private Double goods_price;

	/**
	 * <pre>
	 * 数据库字段: goods_market_price
	 * 描述: market price;字段长度:10,0,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("market price")
    private Double goods_market_price;
	/**
	 * <pre>
	 * 数据库字段: goods_content
	 * 描述: ;字段长度:,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("")
    private String goods_content;
	/**
	 * <pre>
	 * 数据库字段: goods_type_id
	 * 描述: goods's type id;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("goods's type id")
    private Long goods_type_id;
	/**
	 * <pre>
	 * 数据库字段: goods_shop_id
	 * 描述: 菜品对应店铺id;字段长度:200,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty("菜品对应店铺id")
    private Long goods_shop_id;
	/**
	 * <pre>
	 * 数据库字段: goods_sell_sum
	 * 描述: sell sum ;字段长度:11,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("sell sum ")
    private Integer goods_sell_sum;
	/**
	 * <pre>
	 * 数据库字段: is_deleted
	 * 描述: 0 no deleted;1 is deleted.;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("0 no deleted;1 is deleted.")
    private Integer is_deleted;
	/**
	 * <pre>
	 * 数据库字段: is_on_sale
	 * 描述: 0 not on sale;1 is on sale;;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty("0 not on sale;1 is on sale;")
    private Integer is_on_sale;

	private Date update_time;
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
