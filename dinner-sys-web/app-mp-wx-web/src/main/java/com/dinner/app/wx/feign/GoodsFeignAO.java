package com.dinner.app.wx.feign;

import com.dinner.app.wx.feign.impl.GoodsFeignFallbackFactoryImpl;
import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "goods",fallbackFactory = GoodsFeignFallbackFactoryImpl.class)
public interface GoodsFeignAO {

    @PostMapping(value = "goods/queryAllList")
    Result<List<Goods>> queryList(@RequestBody GoodsQuery query);
}
