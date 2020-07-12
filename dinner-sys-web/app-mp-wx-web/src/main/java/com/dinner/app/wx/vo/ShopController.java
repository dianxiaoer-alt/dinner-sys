package com.dinner.app.wx.vo;

import com.dinner.app.wx.feignService.ShopFeign;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    private ShopFeign shopFeign;

    @GetMapping("queryById")
    public Result<Shop> queryOneById(@RequestParam("shopId") Long shopId){
        return shopFeign.queryOneById(shopId);
    }
}
