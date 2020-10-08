package com.dinner.app.wx.ao;

import com.dinner.commons.domain.User;
import com.dinner.commons.request.UserReq;
import com.dinner.commons.result.Result;


public interface UserAO {
    Result<User> queryById(Long userId);

    Result<User> queryOneByOpenId(String openId);

    Result<Long> save(UserReq userReq);
}
