package com.dinner.app.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(value = {"com.dinner.*"})
@EnableFeignClients
public class WXAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WXAppApplication.class,args);
    }
}
