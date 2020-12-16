package com.example.springbootdemo;


import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.async.TestAsync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-19
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncTest {

    @Autowired
    private TestAsync testAsync;

    @Test
    public void test01() throws Exception{
        Future<Map<Integer, String>> mapFuture = testAsync.testAsync();
        Map<Integer, String> integerStringMap = mapFuture.get();
        System.out.println(JSON.toJSONString(integerStringMap));
        System.out.println("任务执行结束");
    }


    @Test
    public void test02() throws Exception{
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        // do something
        Thread.sleep(1000);
        sw.stop();
        sw.start("task2");
        // do something
        Thread.sleep(2000);
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());
    }

    @Test
    public void test03() throws Exception{
        for (int i = 0; i < 100; i++) {
            System.out.println((int) Math.round(Math.random() * 360));
        }
    }

}
