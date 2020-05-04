package com.dinner.shop.admin.vo.error;

import com.dinner.commons.BaseResult;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.result.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/2 20:54
 */
@RestControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Result.error(ErrorEnum.PARAMETER_VALIDATION_ERROR.getCode(),ErrorEnum.PARAMETER_VALIDATION_ERROR.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> Exception(Exception e){
        return Result.error(ErrorEnum.UNKNOW_ERROR.getCode(),ErrorEnum.UNKNOW_ERROR.getMsg());
    }
}
