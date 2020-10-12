package com.dinner.app.wx.pojo.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class UnifiedOrderReq {
    Long shopId;
    Long userId;
    @NotNull
    Long orderId;
    String ip;
    @NotNull
    String body;
    @NotNull
    String desc;
}
