package com.dinner.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dinner.*"})
@EnableEurekaClient
@EnableFeignClients
public class ShopAdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopAdminWebApplication.class,args);
    }
}
