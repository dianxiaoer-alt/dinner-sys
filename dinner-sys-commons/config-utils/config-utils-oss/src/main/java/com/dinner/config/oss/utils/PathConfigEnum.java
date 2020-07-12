package com.dinner.config.oss.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间路径
 */
public enum PathConfigEnum {

    /**
     * 日期格式
     */
    DATE(new SimpleDateFormat("yyyy/MM/dd").format(new Date())),
    /**
     * 日期时间格式
     */
    DATETIME(new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss").format(new Date()));


    private String PATH;

    PathConfigEnum(String PATH){
        this.PATH = PATH;
    }

    public String getPath(){
        return PATH;
    }
}
