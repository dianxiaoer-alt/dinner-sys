package com.dinner.shop.admin.vo.base;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {

    static String DEFAULT_STR = "shop_id";

    protected Long parseShopId(HttpServletRequest request){
        return parseLong(DEFAULT_STR,request);
    }

    private Long parseLong(String str,HttpServletRequest request){
        if (StringUtils.isBlank(str))
            return null;
        Object obj = request.getAttribute(str);
        if (obj == null)
            return null;
        return Long.parseLong(request.getAttribute(str).toString());
    }
}
