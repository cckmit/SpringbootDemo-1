package com.example.springbootdemo.guava.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: springboot-demo
 * @description: guava限流器网关
 * @author: swd
 * @create: 2020-08-03
 **/
@RestController
@RequestMapping("/rateLimiter")
public class RateLimiterController {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

    /**
     * tryAcquire尝试获取permit，默认超时时间是0，意思是拿不到就立即返回false
     */
    @GetMapping("/sayHello")
    public String sayHello() {
        //  一次拿1个
        if (RATE_LIMITER.tryAcquire()) {
            System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("limit");
        }
        return "hello";
    }

    /**
     * acquire拿不到就等待，拿到为止
     */
    @GetMapping("/sayHi")
    public String sayHi() {
        //  一次拿5个
        RATE_LIMITER.acquire(5);
        System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date()));
        return "hi";
    }
}
