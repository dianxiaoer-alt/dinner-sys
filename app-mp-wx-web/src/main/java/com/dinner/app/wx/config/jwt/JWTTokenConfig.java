package com.dinner.app.wx.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dinner.commons.domain.User;
import org.springframework.beans.factory.annotation.Value;
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
     * @param user
     * @return
     */
    public String getTokenString(User user){
        return JWT.create()
                //jwt签发者
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withAudience(user.getId()+"")
                .sign(Algorithm.HMAC256(user.getAccess_token()));
    }
}
