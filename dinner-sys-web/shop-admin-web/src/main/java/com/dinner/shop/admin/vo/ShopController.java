package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.Shop;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.config.jwt.JWTTokenConfig;
import com.dinner.shop.admin.config.jwt.PassToken;
import com.dinner.shop.admin.config.jwt.UserLoginToken;

import com.dinner.shop.admin.feign.ShopFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 15:49
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopFeign shopFeign;

    @Autowired
    private JWTTokenConfig jwtTokenConfig;

    @PassToken
    @GetMapping("login")
    public Result<String> shopLoginByTelOrEmail(@RequestParam("value") String value, @RequestParam("password") String password){
      Result<Shop> res = shopFeign.shopLoginByTelOrEmail(value,password);
       return Result.success(jwtTokenConfig.getTokenString(res.getData()));
    }


    @UserLoginToken
    @GetMapping("getShopUser")
    public Result<Shop> getShopUser(HttpServletRequest request){
        Long shop_id =Long.parseLong( request.getParameter("shop_id"));
        return Result.success(shopFeign.queryById(shop_id).getData());
    }
}
