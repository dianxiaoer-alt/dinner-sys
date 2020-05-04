package com.dinner.admin.feign;

import com.dinner.admin.feign.impl.UserFeignFallbackFactoryImpl;
import com.dinner.commons.domain.AdminUser;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user",fallbackFactory = UserFeignFallbackFactoryImpl.class)
public interface UserFeign {
    /**************************后台用户**********************************/

    @RequestMapping(value = "adminUser/queryUserByUserName")
    Result<AdminUser> queryUserByUserName(@RequestParam("username") String username);
}
