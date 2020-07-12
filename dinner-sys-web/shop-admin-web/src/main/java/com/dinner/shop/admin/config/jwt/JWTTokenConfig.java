package com.dinner.shop.admin.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dinner.commons.domain.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/4 21:36
 */
@Component
public class JWTTokenConfig {
    @Value("${jwt.issuer}")
    private String issuer;

    /**
     * JWT token String
     * @param shop
     * @return
     */
    public String getTokenString(Shop shop){
        return JWT.create()
                //jwt签发者
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withAudience(shop.getId()+"")
                .sign(Algorithm.HMAC256(shop.getShop_password()));
    }
}
