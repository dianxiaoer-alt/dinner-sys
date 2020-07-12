package com.dinner.admin.feign.impl;

import com.dinner.admin.contants.AbstractFallbackFactory;
import com.dinner.admin.feign.UserFeign;
import com.dinner.commons.domain.AdminUser;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 14:52
 */
@Service
public class UserFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {
            @Override
            public Result<AdminUser> queryUserByUserName(String username) {
                return Result.error(ERR_CODE,ERR_MSG);
            }
        };
    }
}
