package com.dinner.app.wx.ao.impl;

import com.dinner.app.wx.ao.UserAO;
import com.dinner.app.wx.feign.UserFeignAO;
import com.dinner.commons.domain.User;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userAO")
public class UserAOImpl implements UserAO {
    @Autowired
    UserFeignAO userFeignAO ;

    @Override
    public Result<User> queryById(Long userId) {
        return userFeignAO.queryById(userId);
    }

    @Override
    public Result<User> queryOneByOpenId(String openId) {
        return userFeignAO.queryOneByOpenId(openId);
    }

    @Override
    public Result<Long> save(UserReq userReq) {
        return userFeignAO.save(userReq);
    }
}
