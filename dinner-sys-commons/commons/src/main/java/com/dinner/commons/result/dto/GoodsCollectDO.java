package com.dinner.commons.result.dto;

import com.dinner.commons.domain.GoodsCollect;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsCollectDO extends GoodsCollect {

    //返回商品部分

    private String goods_title;

    private String goods_head_img;

    private Double goods_price;

    private Double goods_market_price;

    private String goods_content;

    private Long goods_type_id;

    private Long goods_shop_id;

    private Integer goods_sell_sum;

    private Integer goods_is_deleted;

    private Integer goods_is_on_sale;
}
