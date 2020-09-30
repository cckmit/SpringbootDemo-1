package com.example.springbootdemo.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {_IDCustomValid.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IDCustomValid {

    String message() default "ID为32位有效ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
