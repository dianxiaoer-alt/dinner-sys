package com.dinner.admin.vo.exception;

import com.dinner.commons.BaseResult;
import com.dinner.commons.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    //参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult result = e.getBindingResult();
        FieldError fieldError = result.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        return new Result(11000,e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public BaseResult handleMethodException(Exception e) {
       e.printStackTrace();
        return new Result(11000,"未知错误");
    }
}
