package com.dinner.commons.error;

import com.dinner.commons.result.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 功能描述： 控制器全局异常处理  全局配置
 *
 * @author:陈丽强
 * @Date:2020/5/19 22:48
 */
@RestControllerAdvice
public class AbstractControllerAdvice {
    //参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return Result.error(ErrorEnum.PARAM_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public Result handleMethodException(Exception e) {
        e.printStackTrace();
        return Result.error(ErrorEnum.UNKNOW_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public Result handleMethodException(SQLException e) {
        e.printStackTrace();
        return  Result.error(ErrorEnum.SQL_VISIT_ERROR);
    }


    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException ex) {
        return Result.error(ErrorEnum.RUNING_ERROR);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        return Result.error(ErrorEnum.NO_POINT_ERRPR);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        return Result.error(ErrorEnum.CLASS_CAST_ERROR);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        return Result.error(ErrorEnum.IO_ERROE);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return Result.error(ErrorEnum.NO_METHOD_ERROR);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return Result.error(ErrorEnum.OUT_OF_BOUNDS_ERROR);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result requestNotReadable(HttpMessageNotReadableException ex) {
        return Result.error(ErrorEnum.NOT_READ_ERROR);
    }



    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result request405(HttpRequestMethodNotSupportedException ex) {
        return Result.error(ErrorEnum.METHOD_NOT_SUPPORT_ERROR);
    }


    //404错误
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result server404(NoHandlerFoundException ex) {
        return Result.error(ErrorEnum.NO_HANDLER_FOUND_ERROR);
    }




}
