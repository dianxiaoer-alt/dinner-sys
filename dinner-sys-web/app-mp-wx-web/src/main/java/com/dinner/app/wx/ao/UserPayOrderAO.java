package com.dinner.app.wx.ao;

import com.dinner.app.wx.pojo.request.UnifiedOrderReq;
import com.dinner.commons.result.Result;

import java.util.Map;

public interface UserPayOrderAO {

    /**
     *
     * @param req
     * @return
     */
    Result<Map<String, String>> unifiedOrder(UnifiedOrderReq req);
}
