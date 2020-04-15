package com.dinner.commons.result;

/**
 * @description: 自定义状态码枚举类
 * @author: jiankang.xia@bees360.com
 * @date: 2019-04-30 15:16
 */
public enum ResultCodeEnum {


    /**
     * 成功状态码
     */
    SUCCESS(0, "SUCCESS"),

    /**
     * 失败状态码
     */
    FAIL(1,"FAIL"),

    /**
     * 参数错误
     */
    PARAMS_IS_NULL(100, "PARAMS_IS_NULL：%s"),
    PARAMS_NOT_COMPLETE(101, "PARAMS_NOT_COMPLETE：%s"),
    PARAMS_TYPE_ERROR(102, "PARAMS_TYPE_ERROR：%s"),
    PARAMS_IS_INVALID(103, "PARAMS_IS_INVALID：%s"),

    /**
     *  数据错误
     */
    DATA_NOT_FOUND(200, "DATA_NOT_FOUND"),
    DATA_IS_WRONG(201, "DATA_IS_WRONG"),
    DATA_ALREADY_EXISTED(202, "DATA_ALREADY_EXISTED"),

    /**
     * 用户错误
     */
    USER_NOT_EXIST(300, "USER_NOT_EXIST"),
    USER_NOT_LOGGED_IN(301, "USER_NOT_LOGGED_IN"),
    USER_ACCOUNT_ERROR(302, "USER_ACCOUNT_ERROR"),
    USER_ACCOUNT_FORBIDDEN(303, "USER_ACCOUNT_FORBIDDEN"),
    USER_HAS_EXIST(304, "USER_HAS_EXIST"),

    /**
     * 系统错误
     */
    SYSTEM_INNER_ERROR(400, " SYSTEM_INNER_ERROR"),
    SERVICE_TRANSFER_ERROR(401,"SERVICE_TRANSFER_ERROR"),
    SERVICE_HYSTRIX_ERROR(402,"SERVICE_HYSTRIX_ERROR"),

    /**
     * 接口错误
     */
    INTERFACE_INNER_INVOKE_ERROR(500, "INTERFACE_INNER_INVOKE_ERROR"),
    INTERFACE_OUTER_INVOKE_ERROR(501, "INTERFACE_OUTER_INVOKE_ERROR"),
    INTERFACE_FORBIDDEN(502, "INTERFACE_FORBIDDEN"),
    INTERFACE_ADDRESS_INVALID(503, "INTERFACE_ADDRESS_INVALID"),
    INTERFACE_REQUEST_TIMEOUT(504, "INTERFACE_REQUEST_TIMEOUT"),
    INTERFACE_EXCEED_LOAD(505, "INTERFACE_EXCEED_LOAD"),

    /**
     * 业务错误
     */
    BUSINESS_ERROR(600, "BUSINESS_ERROR"),
    ID_GENERATOR_ERROR(601,"ID_GENERATOR_ERROR"),
    HTTP_REQUEST_METHOD_ERROR(602, "HTTP_REQUEST_METHOD_ERROR"),
    CODE_IS_EXIST_ERROR(603, "CODE_IS_EXIST_ERROR"),

    /**
     * 权限错误
     */
    PERMISSION_NO_ACCESS(700, "PERMISSION_NO_ACCESS"),


    /**
     * 基础数据
     */
    TYPE_CODE_ALREADY_EXSIT(901,"TYPE_CODE_ALREADY_EXSIT！"),


    /***
     * 文件上传
     */
    FILE_UPLOAD_ERROR(801,"FILE_UPLOAD_ERROR"),
    FILE_DOWNLOAD_ERROR(802,"FILE_DOWNLOAD_ERROR"),
    FILE_DELETE_ERROR(803,"FILE_DELETE_ERROR"),
    FILE_GET_ERROR(804,"FILE_GET_ERROR"),
    FILE_TYPE_ERROR(805,"FILE_TYPE_ERROR"),;


    private int code;
    private String msg;

    ResultCodeEnum() {
    }

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

    public ResultCodeEnum fillArgs(Object... args) {
        this.msg = String.format(this.msg, args);
        return this;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum [code=" + code + ", msg=" + msg + "]";
    }
}
