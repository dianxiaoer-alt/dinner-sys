/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.request;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *  菜品购物车接收参数，提供服务接口模型
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
@ApiModel(description = "请求实体类GoodsCollectReq 菜品购物车")
public class GoodsCollectReq {
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goodsCollect.id.notNoll.message}")
    private Long id;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goodsCollect.goods_id.notNoll.message}")
    private Long goods_id;
	/**
	 * <pre>
	 *  ;字段长度:4,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
	@NotNull(message = "{com.dinner.goods.goodsCollect.goods_num.notNoll.message}")
    private Integer goods_num;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goodsCollect.user_id.notNoll.message}")
    private Long user_id;
	/**
	 * <pre>
	 *  ;字段长度:100,是否必填:是。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1000", dataType = "Long")
	@NotNull(message = "{com.dinner.goods.goodsCollect.shop_id.notNoll.message}")
    private Long shop_id;
	/**
	 * <pre>
	 *  ;字段长度:1,是否必填:否。
	 * </pre>
	 */
	@ApiModelProperty(value = "", example = "1", dataType = "Integer")
    private Integer is_deleted;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
