package com.example.springbootdemo;

import com.example.springbootdemo.pattern.strategy.dto.OrderBO;
import com.example.springbootdemo.pattern.strategy.dto.OrderDTO;
import com.example.springbootdemo.pattern.strategy.serviceimpl.DispatchModeProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatternStrategyTest {

    @Autowired
    private DispatchModeProcessor dispatchModeProcessor;



   @Test
    public void test01() {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId("1234");
        dto.setType(2);
        dispatchModeProcessor.add(dto);
        OrderBO bo = new OrderBO();
        bo.setOrderId("5678");
        bo.setType(1);
        dispatchModeProcessor.add(bo);
    }


    @Test
    public void test02() {
       String s = null;
        System.out.println(Long.parseLong(s));
    }
}
