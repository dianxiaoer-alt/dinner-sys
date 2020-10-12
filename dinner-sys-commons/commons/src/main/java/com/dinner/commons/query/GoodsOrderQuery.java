/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.commons.query;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.dinner.commons.query.base.Query;

import lombok.Getter;
import lombok.Setter;
/**
 * <pre>
 *  用户订单 查询条件,专门提供查询使用，请勿当成提交数据保存使用，
 *	如果有必要新增额外领域模型数据，可以单独创建，请勿使用查询对象做提交数据保存
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Getter
@Setter
public class GoodsOrderQuery extends Query {

    private Long user_id;

    private Long shop_id;

    private Integer is_payed;

    @Override
    public String toString() {
      return ReflectionToStringBuilder.toString(this);
    }

}
