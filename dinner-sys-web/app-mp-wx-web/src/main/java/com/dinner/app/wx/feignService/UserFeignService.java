package com.dinner.app.wx.feignService;

import com.dinner.app.wx.feignService.impl.UserFeignFallbackFactoryImpl;
import com.dinner.commons.domain.User;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/21 12:42
 */
@FeignClient(value = "user",fallbackFactory = UserFeignFallbackFactoryImpl.class)
public interface UserFeignService {
    @GetMapping("user/queryById")
    Result<User> queryById(@RequestParam("userId") Long userId);

    @GetMapping("user/queryUserByOpenId")
    Result<User> queryOneByOpenId(@RequestParam("openId")String openId);

    @PostMapping("user/save")
     Result<Long> save(@RequestBody UserReq userReq);
}
