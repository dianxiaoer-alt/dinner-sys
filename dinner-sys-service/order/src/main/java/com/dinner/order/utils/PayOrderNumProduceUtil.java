package com.dinner.order.utils;



import com.dinner.commons.utils.DateUtils;

import java.util.Date;

/**
 * 功能描述：支付账单生成工具
 *
 * @author:陈丽强
 * @Date:2020/5/31 15:32
 */
public class PayOrderNumProduceUtil {
    private static String wxOrderPrefix = "WX";
    private static String alipayOrderPrefix = "ALIPAY";

    /**
     * 微信生产订单编号策略
     * @param user_id
     * @param price
     * @return
     */
    public static String wxProductOrderNum(Integer user_id,double price){
        StringBuffer buffer = new StringBuffer(wxOrderPrefix);
        buffer.append(DateUtils.format(new Date(),"yyyyMMddHHmmss"));
        buffer.append(user_id);
        buffer.append((int)price);
        return buffer.toString();
    }

    /**
     * 支付宝生产订单编号策略
     * @param user_id
     * @param price
     * @return
     */
    public static String alipayProductOrderNum(Integer user_id, double price){
        StringBuffer buffer = new StringBuffer(alipayOrderPrefix);
        buffer.append(DateUtils.format(new Date(),"yyyyMMddHHmmss"));
        buffer.append(user_id);
        buffer.append((int)price);
        return buffer.toString();
    }

    /**
     * 提現账单号
     * @param user_id
     * @param price
     * @return
     */
    public static String wxWithdrowOrderNum(Integer user_id,Double price){
        StringBuffer buffer = new StringBuffer(wxOrderPrefix);
        buffer.append(DateUtils.format(new Date(),"yyyyMMddHHmmss"));
        buffer.append(user_id);
        buffer.append(price.intValue());
        return buffer.toString();
    }

    /**
     * 提現账单号
     * @param user_id
     * @param price
     * @return
     */
    public static String alipayWithdrowOrderNum(Integer user_id,Double price){
        StringBuffer buffer = new StringBuffer(alipayOrderPrefix);
        buffer.append(DateUtils.format(new Date(),"yyyyMMddHHmmss"));
        buffer.append(user_id);
        buffer.append(price.intValue());
        return buffer.toString();
    }

}
