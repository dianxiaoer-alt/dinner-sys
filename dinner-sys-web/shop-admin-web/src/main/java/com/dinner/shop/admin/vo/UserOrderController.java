package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.config.jwt.UserLoginToken;
import com.dinner.shop.admin.feign.UserOrderFeign;
import com.dinner.shop.admin.vo.base.AbstractController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("order")
public class UserOrderController extends AbstractController {
    @Autowired
    private UserOrderFeign userOrderFeign;

    @UserLoginToken
    @PostMapping(value = "queryList")
    Result<List<GoodsOrder>> queryList( GoodsOrderQuery query, HttpServletRequest request){
        query.setShop_id(parseShopId(request));
        return userOrderFeign.queryList(query);
    }

    @UserLoginToken
    @PostMapping(value = "queryPage")
    PageResult<GoodsOrder> queryPage(GoodsOrderQuery query, HttpServletRequest request){
        query.setShop_id(parseShopId(request));
        return userOrderFeign.queryPage(query);
    }

    @UserLoginToken
    @GetMapping(value = "queryById")
    Result<GoodsOrder> queryById(@RequestParam("goodsOrderId") Long goodsOrderId){
        return userOrderFeign.queryById(goodsOrderId);
    }

    @UserLoginToken
    @GetMapping(value = "queryOrderDetailById")
    Result<OrderDetail> queryOrderDetailById(@RequestParam("orderDetailId")Long orderDetailId){
        return userOrderFeign.queryOrderDetailById(orderDetailId);
    }
}
