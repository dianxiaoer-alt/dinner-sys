package com.dinner.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dinner.*")
public class ShopAdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopAdminWebApplication.class,args);
    }
}
