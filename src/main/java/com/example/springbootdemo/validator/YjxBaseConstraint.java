package com.example.springbootdemo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 当字段等于某个值时,就使某些列的校验生效
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {YjxBaseConstraintValidator.class})
public @interface YjxBaseConstraint {
    /**
     * 恒等值
     */
    long identity();

    /**
     * 校验列
     */
    String[] checkColumn() default {};

    String message() default "{org.validator.constraints.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
