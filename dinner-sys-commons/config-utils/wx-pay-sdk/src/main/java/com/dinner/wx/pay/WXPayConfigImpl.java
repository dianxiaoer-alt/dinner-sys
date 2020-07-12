package com.dinner.wx.pay;



import com.dinner.wx.pay.constants.WXPayConstants;
import com.dinner.wx.pay.constants.WXPayRequestConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 微信支付配置接口实现类
 *
 * @author yclimb
 * @date 2018/8/17
 */
public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private  WXPayConfigImpl INSTANCE;
    WXPayRequestConfig wxPayConfig;

    private WXPayConfigImpl(WXPayRequestConfig wxPayConfig) throws Exception {
        String certPath =wxPayConfig.getAPICLIENT_CERT();
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public  WXPayConfigImpl getInstance() throws Exception {
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl(wxPayConfig);
                }
            }
        }
        return INSTANCE;
    }



    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    protected WXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}
