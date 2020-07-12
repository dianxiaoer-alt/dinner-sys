package com.dinner.config.oss.factory.impl;

import com.dinner.config.oss.client.AbstractDinnerOssClient;
import com.dinner.config.oss.config.OssConfig;
import com.dinner.config.oss.factory.AbstractUpload;
import com.dinner.config.oss.client.DinnerOssClient;
import com.dinner.config.oss.factory.OssUploadFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OssUploadFactoryBuilder extends AbstractUpload implements OssUploadFactory {

    public OssUploadFactoryBuilder(OssConfig ossConfig){
        AbstractDinnerOssClient.ossConfig = ossConfig;
    }


    @Override
    public DinnerOssClient build(InputStream inputStream, String path,Boolean fileRename,String filename,String suffix)throws Exception {
        valid(suffix);//验证文件拓展名
        if (StringUtils.isEmpty(filename))
            filename = UUID.randomUUID().toString().replace("-","");
        if (StringUtils.isEmpty(path))
            throw new RuntimeException("path不能为空");
        List<String> list = Arrays.asList(DEFAULT_ALLOWED_EXTENSION);
        if(list.contains(suffix))
            suffix="";
       return new DinnerOssClient(inputStream,path,fileRename,filename,suffix);
    }

    @Override
    public DinnerOssClient build(MultipartFile multipartFile, String path, Boolean fileRename) throws Exception{
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        String filename = multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().lastIndexOf("."));
        return build(multipartFile.getInputStream(),path,fileRename,filename,suffix);
    }


    @Override
    public boolean valid(String suffix) {
        List<String> list = Arrays.asList(DEFAULT_ALLOWED_EXTENSION);
        if(list.contains(suffix))
            return true;
        throw new RuntimeException("不允许该类型文件上传");
    }
}
