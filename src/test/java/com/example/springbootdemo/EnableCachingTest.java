package com.example.springbootdemo;

import com.example.springbootdemo.caching.EnableCachingBean;
import com.example.springbootdemo.caching.EnableCachingService;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-19
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class EnableCachingTest {

    @Autowired
    private EnableCachingService enableCachingService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test03(){
        BigDecimal inventory = new BigDecimal("1554");
        Integer specQuantity = new Integer("14");
        String minUnit = "包";
        String maxUnit = "件";
        BigDecimal bigDecimal = BigDecimal.valueOf(specQuantity);


        BigDecimal bg = BigDecimal.valueOf(specQuantity);
        System.out.println(inventory.divideAndRemainder(bg)[1]);//取余
        System.out.println(1554%15);//取余

        BigDecimal divide = inventory.divide(bigDecimal, 0, BigDecimal.ROUND_DOWN);

       if (inventory.divideAndRemainder(bg)[1].compareTo(BigDecimal.ZERO)==0){
           System.out.println(divide+maxUnit+BigDecimal.ZERO+minUnit);
       }else {
           System.out.println(divide+maxUnit+inventory.divideAndRemainder(bg)[1]+minUnit);
       }

    }

    @Test
    public void test02(){
        Set<String> strings = Sets.newHashSet("123", "234");
        redisTemplate.opsForValue().set("test",strings,30, TimeUnit.SECONDS);

        Set<String> o = (Set)redisTemplate.opsForValue().get("test");


    }

    @Test
    public void test01(){
        EnableCachingBean query = new EnableCachingBean();
        query.setJpShopId("123456789");
        query.setState(1);
        enableCachingService.select(query);
        enableCachingService.select(query);

        query.setState(2);
        enableCachingService.insert(query);



        enableCachingService.select(query);
        enableCachingService.select(query);

        enableCachingService.delete(query);

        enableCachingService.select(query);
        enableCachingService.select(query);

    }
}
