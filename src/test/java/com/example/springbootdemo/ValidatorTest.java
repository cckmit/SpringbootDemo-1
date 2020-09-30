package com.example.springbootdemo;

import com.example.springbootdemo.scheduled.bean.BaseTemp;
import com.example.springbootdemo.scheduled.bean.MessageDTO;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.utils.ValidatorUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
@SpringBootTest
public class ValidatorTest {

    @Test
    public void test01(){
        MessageDTO s = new MessageDTO();
        long startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        s.setUsername("小明");
        s.setBirthday("2016-9-1");
        startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test02(){

        BaseTemp baseTemp = test03();
    }

    private BaseTemp test03(){
        Temp temp = new Temp();
        temp.setPromotionPrice(new BigDecimal("1"));
        return temp;
    }

    private static void print(Map<String,StringBuffer> errorMap){
        if(errorMap != null){
            for(Map.Entry<String, StringBuffer> m : errorMap.entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue().toString());
            }
        }
    }

}
