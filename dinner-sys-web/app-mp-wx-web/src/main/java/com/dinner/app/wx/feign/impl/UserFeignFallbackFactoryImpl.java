package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.UserFeignAO;
import com.dinner.commons.domain.User;
import com.dinner.commons.error.ErrorEnum;
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
@Service("userFeignAO")
public class UserFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<UserFeignAO> {
    @Override
    public UserFeignAO create(Throwable throwable) {
        return new UserFeignAO() {
            @Override
            public Result<User> queryById(Long userId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<User> queryOneByOpenId(String openId) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }

            @Override
            public Result<Long> save(UserReq userReq) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
