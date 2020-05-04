package com.dinner.commons.error;

/**
 * 功能描述：错误码
 *
 * @author:陈丽强
 * @Date:2020/5/2 19:56
 */
public enum ErrorEnum {


    /************数据源*************/
    SQL_ERROR(100000,"SQL语句错误"),
    ADD_DATA_SUCCESS(100001,"新增成功"),
    ADD_DATA_FAIL(100002,"新增失败"),
    UPDATE_DATA_SUCCESS(100003,"更新成功"),
    UPDATE_DATA_FAIL(100004,"更新失败"),
    SELECT_DATA_SUCCESS(100005,"查询成功"),
    SELECT_DATA_FAIL(100006,"查询失败"),
    DELETE_DATA_SUCCESS(100007,"删除成功"),
    DELETE_DATA_FAIL(100008,"删除失败"),
    NET_DATASOURCE_FAIL(100009,"数据库连接失败"),
    NO_DATA(100010,"无数据"),



    /******************方法通用类型*******************/
    OPERATE_SUCCESS(200000,"操作成功"),
    OPERATE_FAIL(200001,"操作失败"),
    PARAMETER_VALIDATION_ERROR(200002,"参数不合法"),
    NOT_FOUNT_METHOD(200003,"找不到方法"),





    /*************************SpringCloud*****************************/
    SERVER_NO_RESPONSE(300000,"服务无响应"),
    SERVER_ERROR_RESPONSE(300001,"服务响应异常"),
    SERVER_DOWN(300002,"服务中断"),




    /****************************Spring Mvc**********************************/
    URL_NOT_FOUND(400000,"URL异常"),
    /***
     * 文件上传
     */
    FILE_UPLOAD_ERROR(500000,"FILE_UPLOAD_ERROR"),
    FILE_DOWNLOAD_ERROR(500001,"FILE_DOWNLOAD_ERROR"),
    FILE_DELETE_ERROR(500002,"FILE_DELETE_ERROR"),
    FILE_GET_ERROR(500003,"FILE_GET_ERROR"),
    FILE_TYPE_ERROR(500004,"FILE_TYPE_ERROR"),

    UNKNOW_ERROR(600000,"未知异常"),





    /*******************************************/
    USER_NAME_PWD_ERROE(700000,"请检查用户名或密码是否正确"),
    USER_REPEAT_ERROR(700001,"请勿重复注册"),
    IDENTITY_IS_OVERDUE(700002,"身份过期，请登录"),
    AUTHENTICATION_FAILED(700003,"身份验证失败"),
    ;




    private Integer code;
    private String msg;
    ErrorEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){return this.msg;}
    public Integer getCode(){return this.code;}

}
