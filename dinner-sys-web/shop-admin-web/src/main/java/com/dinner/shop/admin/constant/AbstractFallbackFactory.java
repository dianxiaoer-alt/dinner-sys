package com.dinner.shop.admin.constant;

import com.dinner.commons.error.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 14:43
 */
public class AbstractFallbackFactory {
    protected static final String ERR_MSG = ErrorEnum.SERVER_DOWN.getMsg();
    protected static final Integer ERR_CODE = ErrorEnum.SERVER_DOWN.getCode();
    protected static final  Logger log = LoggerFactory.getLogger(AbstractFallbackFactory.class);

}
