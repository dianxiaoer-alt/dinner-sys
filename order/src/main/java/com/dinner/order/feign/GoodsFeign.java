package com.dinner.order.feign;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("goods")
public interface GoodsFeign {

    @RequestMapping("goods/queryById")
    Result<Goods> queryById(@RequestParam("goodsId") Long goodsId);
}
