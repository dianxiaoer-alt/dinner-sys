package com.dinner.admin.config;

import com.dinner.admin.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单认证
        http.formLogin()
                //.failureHandler(new MyAuthenticationFailureHandler("/fail.html"))
                .loginProcessingUrl("/login")   //当发现/login时认为是登录，需要执行UserDetailsServiceImpl
                .successHandler(new MyAuthenticationSuccessHandler("./views/index.html"))
                .loginPage("/login.html");
;
        // url 拦截 (授权)
        http.authorizeRequests()
                .antMatchers("/login.html","/adminUser/save").permitAll() //login.html不需要被认证

                .anyRequest().authenticated();//所有的请求都必须被认证。必须登录后才能访问。

        //关闭csrf防护
        http.csrf().disable();

        http.headers().frameOptions().disable(); //页面中iframe加载






    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                // 忽略不需要身份验证的uri
                .ignoring()
                // 如果有静态文件
                .mvcMatchers("/css/**", "/js/**","fonts/**","img/**");

    }



    @Bean
    public PasswordEncoder getPe(){
        return new BCryptPasswordEncoder();
    }
}
