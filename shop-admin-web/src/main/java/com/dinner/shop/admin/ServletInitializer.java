package com.dinner.shop.admin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/4 15:00
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShopAdminWebApplication.class);
    }
}
