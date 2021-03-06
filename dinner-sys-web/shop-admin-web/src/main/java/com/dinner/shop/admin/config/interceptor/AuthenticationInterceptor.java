package com.dinner.shop.admin.config.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.config.jwt.PassToken;
import com.dinner.shop.admin.config.jwt.UserLoginToken;
import com.dinner.shop.admin.config.jwt.UserPassToken;

import com.dinner.shop.admin.feign.ShopFeign;
import lombok.extern.slf4j.Slf4j;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 功能描述：登录拦截
 *
 * @author:陈丽强
 * @Date:2020/5/2 16:09
 */
@Configuration
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private ShopFeign shopFeign ;

    @Value("${jwt.issuer}")
    private String issuer;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");

        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();
        log.info("handlerMethod -> {} "+handlerMethod);


        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                log.info("PassToken");
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {

            String token = request.getHeader("authorization");// 从 http 请求头中取出 token
            if(StringUtils.isBlank(token)){
                token = request.getParameter("authorization");
            }
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (StringUtils.isBlank(token)) {
                    //无token，请重新登录
                    print(response,ErrorEnum.IDENTITY_IS_OVERDUE);
                    return false;
                }else{
                    // 获取 token 中的 shop_id
                    Long shop_id = null;
                    try {
                        DecodedJWT decodedJWT = JWT.decode(token);
                        shop_id = Long.parseLong(decodedJWT.getAudience().get(0));

                        //验证签发方是否正确
                        if(!StringUtils.equals(decodedJWT.getIssuer(), issuer)){
                            print(response,ErrorEnum.AUTHENTICATION_FAILED);
                            return false;
                        }
                    } catch (JWTDecodeException j) {
                        print(response,ErrorEnum.AUTHENTICATION_FAILED);
                    }

                    Result<Shop> shop =shopFeign.queryById(shop_id);

                    if (shop.getData() == null) {
                        //用户不存在，请重新登录
                        print(response,ErrorEnum.AUTHENTICATION_FAILED);
                        return false;
                    }
                    // 验证 token
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(shop.getData().getShop_password())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        //验证失败
                        print(response,ErrorEnum.AUTHENTICATION_FAILED);
                    }
                    request.setAttribute("shop_id", shop.getData().getId());
                }


                return true;
            }
        }


        //检查是否有获取用户信息，但不拦截注解
        if (method.isAnnotationPresent(UserPassToken.class)) {
            String token = request.getHeader("authorization");// 从 http 请求头中取出 token
            log.info("UserPassToken");
            UserPassToken userPassToken = method.getAnnotation(UserPassToken.class);
            if (userPassToken.required()) {
                // 执行认证
                if (StringUtils.isBlank(token)) {
                    //无token，请重新登录
                    request.setAttribute("shop_id", null);
                    return true;
                }else{
                    // 获取 token 中的 userId
                    Long shop_id = null;
                    DecodedJWT decodedJWT = JWT.decode(token);
                    shop_id = Long.parseLong(decodedJWT.getAudience().get(0));
                    //验证签发方是否正确
                    if(!StringUtils.equals(decodedJWT.getIssuer(), issuer)){
                        print(response,ErrorEnum.AUTHENTICATION_FAILED);
                    }
                    request.setAttribute("shop_id", shop_id);
                }

                return true;
            }
        }



        return false;
    }




    /**
     * 登录失败
     * @param response
     * @throws IOException
     */
    private void print(HttpServletResponse response,ErrorEnum errorEnum) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(JSONObject.fromObject(Result.error(errorEnum)) );
        out.flush();
        out.close();
    }
}
