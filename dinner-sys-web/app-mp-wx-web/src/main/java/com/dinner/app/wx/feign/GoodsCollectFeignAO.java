package com.dinner.app.wx.feign;

import com.dinner.app.wx.feign.impl.GoodsCollectFeignFallbackImpl;
import com.dinner.app.wx.feign.impl.GoodsFeignFallbackFactoryImpl;
import com.dinner.commons.domain.GoodsCollect;
import com.dinner.commons.query.GoodsCollectQuery;
import com.dinner.commons.request.GoodsCollectReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.dto.GoodsCollectDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "goods",fallbackFactory = GoodsCollectFeignFallbackImpl.class)
public interface GoodsCollectFeignAO {

    @PostMapping("goodsCollect/save")
    Result<Long> save(@Valid @RequestBody GoodsCollectReq goodsCollectReq);

    @PostMapping("goodsCollect/update")
    Result<Integer> update(@Valid @RequestBody GoodsCollectReq goodsCollectReq);

    @PostMapping("goodsCollect/queryList")
    Result<List<GoodsCollectDO >> queryList(@Valid @RequestBody GoodsCollectQuery query);


    @RequestMapping(value = "goodsCollect/delete",method = RequestMethod.GET)
    Result<Integer> deleteById(@RequestParam("goodsCollectId")Long goodsCollectId);

    @RequestMapping(value ="goodsCollect/queryById",method = RequestMethod.GET)
    Result<GoodsCollectDO > queryById(@RequestParam("goodsCollectId")Long goodsCollectId);

    @GetMapping("goodsCollect/changeDeleted")
    Result<Integer> changeDeleted(@RequestParam("goodsCollectIds")String goodsCollectIds);
}
