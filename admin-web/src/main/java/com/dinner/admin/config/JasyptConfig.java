package com.dinner.admin.config;

import com.dinner.commons.utils.JasyptUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    @Value("${jasypt.encryptor.password}")
    private String jasypt_key;

    /**
     * 加密
     * @param value 加密字符串
     * @return 加密后的字符串
     */
    public String encryptPwd(String value){
        return JasyptUtils.encryptPwd(jasypt_key,value);
    }

    /**
     * 解密
     * @param value  未解密字符串
     * @return 解密后的字符串
     */
    public String decyptPwd(String value){
        return JasyptUtils.decyptPwd(jasypt_key,value);
    }
}
