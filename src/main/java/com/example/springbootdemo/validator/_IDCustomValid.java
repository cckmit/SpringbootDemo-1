package com.example.springbootdemo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
public class _IDCustomValid implements ConstraintValidator<IDCustomValid,String> {
    @Override
    public void initialize(IDCustomValid constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(null == value) {
            return false;
        }
        if(value.trim().length()>=32) {
            return true;
        }
        return false;
    }

}
