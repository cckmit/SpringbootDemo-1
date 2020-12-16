package com.example.springbootdemo.service;

import com.example.springbootdemo.Annotation.AutoCache;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.utils.SpringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-12-16
 **/
@Component
public class TestService {


    public String testAutoCache(Temp dto) {

        String token = SpringUtils.getBean(TestService.class).getToken();
        return token;
    }


    @AutoCache
    protected String getToken() {
        System.out.println("执行了getToekn");
        return "OK";
    }
}
