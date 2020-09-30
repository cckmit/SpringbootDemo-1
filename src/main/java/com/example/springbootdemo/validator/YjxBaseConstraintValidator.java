package com.example.springbootdemo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @program: springboot-demo
 * @description: 自定义验证注解
 * @author: swd
 * @create: 2020-07-30
 **/
public class YjxBaseConstraintValidator implements ConstraintValidator<YjxBaseConstraint, Number> {

    private long identity;

    @Override
    public void initialize(YjxBaseConstraint constraintAnnotation) {
        this.identity = constraintAnnotation.identity();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        // null values are valid
        if (value == null) {
            return true;
        }

        else if (value instanceof BigDecimal) {
            return ((BigDecimal) value).compareTo(BigDecimal.valueOf(identity)) == 0;
        } else {
            long longValue = value.longValue();
            return longValue == identity;
        }
    }
}

