package com.dinner.order.feign;

import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.GoodsCollectDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("goods")
public interface GoodsCollectFeign {
    @RequestMapping(value ="goodsCollect/queryById",method = RequestMethod.GET)
    Result<GoodsCollectDO> queryById(@RequestParam("goodsCollectId")Long goodsCollectId);
}
