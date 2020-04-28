package com.dinner.shop.admin.config;

import com.dinner.config.oss.client.DinnerOssClient;
import com.dinner.config.oss.config.OssConfig;
import com.dinner.config.oss.factory.OssUploadFactory;
import com.dinner.config.oss.factory.impl.OssUploadFactoryBuilder;
import com.dinner.config.oss.utils.PathConfigEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 阿里云文件上传
 */
@Configuration
public class OssUploadConfig {
    @Autowired
    private static OssConfig ossConfig;
    static OssUploadFactory ossUploadFactory = new OssUploadFactoryBuilder(ossConfig);

    /**
     *   文件上传
     * @param file
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file) throws Exception {
        DinnerOssClient dinnerOssClient = ossUploadFactory.build(file, PathConfigEnum.DATETIME.getPath(),true);
        return dinnerOssClient.upload();
    }

    /**
     *
     * @param file
     * @param path  定义路径  xx/xx/
     * @param fileRename  是否文件名重命名
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file,String path,boolean fileRename) throws Exception {
        DinnerOssClient dinnerOssClient = ossUploadFactory.build(file, path,fileRename);
        return dinnerOssClient.upload();
    }

    /**
     *
     * @param inputStream
     * @param path
     * @param fileRename
     * @param filename  文件名
     * @param suffix 后拽名
     * @return
     * @throws Exception
     */
    public String upload(InputStream inputStream,String path,boolean fileRename,String filename,String suffix) throws Exception {
        DinnerOssClient dinnerOssClient = ossUploadFactory.build(inputStream, path,fileRename,filename,suffix);
        return dinnerOssClient.upload();
    }


}
