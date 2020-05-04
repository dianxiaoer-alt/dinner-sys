package com.dinner.commons;



import com.dinner.commons.result.ResultCodeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


@Data
@Slf4j
public  class BaseResult {
    public BaseResult(){}
    //状态码
    private Integer code = 0;
    //返回信息
    private String msg = "SUCCESS";

    public BaseResult(Integer code, String msg) {
       this.code=code;
       this.msg = msg;
    }

    public BaseResult(ResultCodeEnum resultCodeEnum){
        if(resultCodeEnum != null){
            this.code = resultCodeEnum.getCode();
            this.msg = resultCodeEnum.getMsg();
        }
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    public static String toString(Object obj) {
        return ReflectionToStringBuilder.toString(obj);
    }


    public boolean isSuccess() {
        return true;
    }
}
