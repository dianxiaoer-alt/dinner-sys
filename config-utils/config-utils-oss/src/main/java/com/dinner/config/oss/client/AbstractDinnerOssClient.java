package com.dinner.config.oss.client;

import com.aliyun.oss.OSSClient;
import com.dinner.config.oss.config.OssConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public abstract class AbstractDinnerOssClient {


    public static OssConfig ossConfig;

    public OSSClient ossClient(){
        log.info("access_id"+ossConfig.getALIYUN_OSS_ACCESSKEYID());
        return new OSSClient(ossConfig.getALIYUN_OSS_ENDPOINT(),ossConfig.getALIYUN_OSS_ACCESSKEYID(),ossConfig.getALIYUN_OSS_ACCESSKEYSECRET());
    }
    /**
     * 上传文件
     * @return
     */
    public abstract String upload();

    /**
     * 删除文件
     */
    public abstract  void delete();


}
