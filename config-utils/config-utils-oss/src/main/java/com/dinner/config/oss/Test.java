package com.dinner.config.oss;

import com.dinner.config.oss.client.DinnerOssClient;
import com.dinner.config.oss.config.OssConfig;
import com.dinner.config.oss.factory.OssUploadFactory;
import com.dinner.config.oss.factory.impl.OssUploadFactoryBuilder;
import com.dinner.config.oss.utils.PathConfigEnum;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Test.class})
@ComponentScan("com.dinner.config.oss.*")
public class Test {
    @Autowired
    private OssConfig ossConfig;
    @org.junit.Test
    public void test() throws Exception {

        OssUploadFactory ossUploadFactory = new OssUploadFactoryBuilder(ossConfig);
        File file = new File("D:/001.jpg");
        InputStream inputStream  = new FileInputStream(file);
        DinnerOssClient dinnerOssClient = ossUploadFactory.build(inputStream, PathConfigEnum.DATETIME.getPath(),true,file.getName(),"png");
        dinnerOssClient.upload();
    }


}
