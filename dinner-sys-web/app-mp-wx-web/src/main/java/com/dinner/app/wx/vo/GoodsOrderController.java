package com.dinner.app.wx.vo;
import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.feign.GoodsOrderFeignAO;
import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("order")
public class GoodsOrderController {

    @Autowired
    private GoodsOrderFeignAO goodsOrderFeignAO;

    @UserPassToken
    @GetMapping("saveByCollectIds")
    public Result<Integer> saveByCollectIds(@RequestParam("goodsCollectIds")String goodsCollectIds, HttpServletRequest request){
       Long shopId =  Long.parseLong(request.getHeader("shopId"));
       Long userId =  Long.parseLong(String.valueOf(request.getAttribute("userId")));
      return goodsOrderFeignAO.saveByCollectIds(goodsCollectIds,shopId,userId);
    }

    @UserPassToken
    @GetMapping(value = "queryById")
    public Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId) {
        return goodsOrderFeignAO.queryById(goodsOrderId);
    }

    @UserPassToken
    @PostMapping(value = "queryList")
    public Result<List<GoodsOrder>> queryList(@RequestBody GoodsOrderQuery query ,HttpServletRequest request) {
        query.setShop_id(Long.parseLong(request.getHeader("shopId")));
        query.setUser_id(Long.parseLong(String.valueOf(request.getAttribute("userId"))));
        return goodsOrderFeignAO.queryList(query);
    }


    @UserPassToken
    @PostMapping(value = "update")
    public Result<Integer> update(@RequestBody GoodsOrderReq goodsOrderReq) {
        return goodsOrderFeignAO.update(goodsOrderReq);
    }

}
