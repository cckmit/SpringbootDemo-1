package com.example.springbootdemo.async;

import com.google.common.collect.Maps;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-12-11
 **/
@Service
public class TestAsync {

    @Async
    public void testAsyncVoid() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(111);
    }

    @Async
    public Future<Map<Integer, String>> testAsync() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName());
        HashMap<Integer, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put(1,"1");
        return new AsyncResult<>(objectObjectHashMap);
    }
}
