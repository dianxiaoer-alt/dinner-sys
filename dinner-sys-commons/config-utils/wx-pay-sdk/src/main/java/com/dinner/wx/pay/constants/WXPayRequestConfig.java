package com.dinner.wx.pay.constants;

import com.dinner.wx.pay.WXPayConfig;
import com.dinner.wx.pay.WXPayDomain;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/11 22:59
 */
@Data
public class WXPayRequestConfig/* extends WXPayConfig*/ {



    /**
     * 公众号、小程序appid
     */
    private  String APP_ID =""; // 真实
    private  String APP_IDs_XXX = "xxx"; // 测试/第二个账号

    /**
     * AppSecret
     */
    private String SECRET =""; // 真实
    private String SECRET_XXX = "xxx"; // 测试/第二个账号

    /**
     * 商户号
     */
    private  String MCH_ID = ""; // 真实
    private String MCH_ID_XXX = "xxx"; // 测试/第二个账号


    /**
     * API密钥，在商户平台设置
     */
    private String API_KEY = ""; // 真实
    private String API_KEY_XXX = "xxx"; // 测试/第二个账号
    private String API_KEY_SANDBOX = "xxx"; // sandbox_signkey

    /**
     * 证书路径
     */
    private String APICLIENT_CERT = "/data/ops/cert/apiclient_cert.p12"; // 真实
    private String APICLIENT_CERT_XXX = "/data/ops/cert_xxx/apiclient_cert.p12"; // 真实
    /**
     * 交易类型
     * JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
     * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
     */
    private String TRADE_TYPE =  "JSAPI";
    private String TRADE_TYPE_APP =  "APP";
    private String TRADE_TYPE_NATIVE =  "NATIVE";

/*    @Override
    public InputStream getCertStream()  throws Exception {
        byte[] certData;
        String certPath =getAPICLIENT_CERT();
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        certData = new byte[(int) file.length()];
        certStream.read(certData);
        certStream.close();
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(certData);
        return certBis;
    }*/

}
