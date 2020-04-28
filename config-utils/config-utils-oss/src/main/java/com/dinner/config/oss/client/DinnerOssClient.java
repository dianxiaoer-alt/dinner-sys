package com.dinner.config.oss.client;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.util.UUID;

@Data
@Slf4j
public class DinnerOssClient extends  AbstractDinnerOssClient{

    private InputStream inputStream;

    private String path;

    private String suffix;

    private String filename;


    private OSSClient ossClient = ossClient();


    private Boolean fileRename;
    public DinnerOssClient(InputStream inputStream, String path,Boolean fileRename,String filename,String suffix){
        this.inputStream  = inputStream;
        this.fileRename = fileRename;
        this.path = path;
        this.suffix = suffix;
        this.filename = filename;
    }

    DinnerOssClient(){}


    @Override
    public String upload() {
        if (fileRename){
            //重命名时保留后拽名
            String suffix = filename.substring(filename.lastIndexOf(".")).toLowerCase();
            filename = UUID.randomUUID().toString().replace("-","")+"."+suffix;
        }

        String filepath = ossConfig.getPREFIX()+"/"+path+"/"+filename;
        if (!StringUtils.isEmpty(suffix))
            filepath+="."+suffix;
        log.info("oss开始上传文件");
        log.info("filepath -> {} "+filepath);
        ossClient.putObject(ossConfig.getALIYUN_BUCKET_NAME(),filepath,inputStream);
        String resStr = "https://"+ossConfig.getALIYUN_BUCKET_NAME()+"."+ossConfig.getALIYUN_OSS_ENDPOINT()+"/"+filepath;
        log.info("访问路径 -> {} "+resStr);
        return resStr;
    }

    @Override
    public void delete() {

    }
}
