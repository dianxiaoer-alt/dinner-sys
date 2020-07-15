package com.dinner.app.wx.vo;

import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.feignService.ShopFeignService;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    private ShopFeignService shopFeignService;

    @UserPassToken
    @GetMapping("queryById")
    public Result<Shop> queryOneById(@RequestParam("shopId") Long shopId){
        return shopFeignService.queryOneById(shopId);
    }
}
