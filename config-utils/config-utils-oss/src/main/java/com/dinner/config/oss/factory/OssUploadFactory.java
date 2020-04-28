package com.dinner.config.oss.factory;


import com.dinner.config.oss.client.DinnerOssClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * chenliqiang
 * 文件上传
 */
public interface OssUploadFactory {




    /**
     *
     * @param inputStream
     * @param path 文件夹定义
     * @param fileRename 文件是否重命名
     * @param suffix 后拽名 jpg，png……
     * @param filename 文件名
     * @return
     */
    DinnerOssClient build(InputStream inputStream,String path,Boolean fileRename,String filename,String suffix)throws Exception;

    /**
     *
     * @param multipartFile
     * @param path 文件夹定义
     * @param fileRename 文件是否重命名
     * @return
     */
    DinnerOssClient build(MultipartFile multipartFile,String path,Boolean fileRename)throws Exception;
}
