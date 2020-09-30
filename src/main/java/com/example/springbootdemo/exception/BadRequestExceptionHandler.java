package com.example.springbootdemo.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-31
 **/
@ControllerAdvice
public class BadRequestExceptionHandler {
    /**
     *  校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONObject validationBodyException(MethodArgumentNotValidException exception){
        JSONObject yjxBaseResult = new JSONObject();
        BindingResult result = exception.getBindingResult();
        if (!result.hasErrors()) {
            return yjxBaseResult;
        }
        List<ObjectError> errors = result.getAllErrors();
        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError) error;
            yjxBaseResult.put(fieldError.getField(),fieldError.getDefaultMessage());
            break;
        }
        //返回自定义错误格式
        return yjxBaseResult;
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public String parameterTypeException(HttpMessageConversionException exception){
        return "类型转换错误";
    }
}
