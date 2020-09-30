package com.example.springbootdemo.advice;

import com.example.springbootdemo.exception.CustomException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
//@ControllerAdvice
public class IRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();



    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
            Set<ConstraintViolation<Object>> validateSet = validator.validate(body, Default.class);
            if(!CollectionUtils.isEmpty(validateSet)){
                 Map<String,String> validateMap = new HashMap<>(16);
                 Set<String> unCheckColumn = new HashSet<>();
                validateSet.forEach(validateEntity->{
                    Map<String, Object> attributes = validateEntity.getConstraintDescriptor().getAttributes();
                    Object columns = attributes.get("checkColumn");
                    if (!StringUtils.isEmpty(columns)){
                        String[] columnsStr = (String[]) columns;
                        unCheckColumn.addAll(Arrays.asList(columnsStr));
                        return;
                    }
                    validateMap.put(validateEntity.getPropertyPath().toString(),validateEntity.getMessage());
                });
               validateMap.forEach((k,v)->{
                   if (!unCheckColumn.contains(k)){
                       throw new CustomException(k+v);
                   }
               });
            }
        return body;
    }
}
