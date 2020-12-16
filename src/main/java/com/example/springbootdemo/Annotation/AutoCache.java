package com.example.springbootdemo.Annotation;


import org.apache.commons.lang3.time.DateUtils;

import java.lang.annotation.*;

/**
 * 自动缓存注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoCache {

    /**
     * 服务名称
     */
    String service() default "SWD-";

    /**
     * 过期时间默认一小时单位秒
     */
    long timeOut() default DateUtils.MILLIS_PER_HOUR/DateUtils.MILLIS_PER_SECOND;
}
