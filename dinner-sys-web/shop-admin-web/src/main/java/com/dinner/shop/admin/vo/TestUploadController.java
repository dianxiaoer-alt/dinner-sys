package com.dinner.shop.admin.vo;

import com.dinner.commons.result.Result;
import com.dinner.config.oss.utils.PathConfigEnum;
import com.dinner.shop.admin.config.oss.OssUploadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("upload")
public class TestUploadController {
    @Autowired
    private OssUploadConfig ossUploadConfig;

    @RequestMapping("start")
    public Result<String> upload() throws Exception {
        File file = new File("D:/001.jpg");
        InputStream inputStream = new FileInputStream(file);
        return Result.success( ossUploadConfig.upload(inputStream, PathConfigEnum.DATE.getPath(),false,file.getName(),"jpg"));
    }
}
