package com.dinner.app.wx.feignService.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feignService.UserFeign;
import com.dinner.commons.domain.User;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;


/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/21 21:41
 */
@Service("UserFeign")
public class UserFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {
            @Override
            public Result<User> queryById(Long userId) {
                return null;
            }

            @Override
            public Result<User> queryOneByOpenId(String openId) {
                return null;
            }

            @Override
            public Result<Long> save(UserReq userReq) {
                return null;
            }
        };
    }
}
