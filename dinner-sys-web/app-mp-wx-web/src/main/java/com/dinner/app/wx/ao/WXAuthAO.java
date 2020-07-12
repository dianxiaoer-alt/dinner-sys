package com.dinner.app.wx.ao;





import com.dinner.commons.domain.User;
import com.dinner.commons.result.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * zuiweng
 */
public interface WXAuthAO {
    /**
     *  用户用code 换取openid和access_token
     * @param code
     * @return
     */
    Result<Map<String,Object>> authorize(String code);


    Result<User> userInfo(String access_token, String open_id, HttpSession session);

    Result<Map<String,Object>> reflushAccessToken(String access_token);
}
