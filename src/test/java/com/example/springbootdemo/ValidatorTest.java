package com.example.springbootdemo;

import com.example.springbootdemo.scheduled.bean.BaseTemp;
import com.example.springbootdemo.scheduled.bean.MessageDTO;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.utils.ValidatorUtil;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        List<String> transform = Lists.transform(integers, String::valueOf);
        ArrayList<String> list = Lists.newArrayList("6");
        list.addAll(transform);
        List<String> collect = list.stream().sorted().collect(Collectors.toList());
    }

    @Test
    public void test02(){
        String s = transformInventoryMaxUnitName(new BigDecimal("31.000").stripTrailingZeros(), 6, "袋", "件");
    }

    private static String transformInventoryMaxUnitName(BigDecimal inventory,Integer specQuantity,String minUnit,String maxUnit){
        BigDecimal specQuantityB = BigDecimal.valueOf(specQuantity);
        BigDecimal divide = inventory.divide(specQuantityB, 0, BigDecimal.ROUND_DOWN);
        if (inventory.divideAndRemainder(specQuantityB)[1].compareTo(BigDecimal.ZERO)==0){
            return divide+maxUnit+BigDecimal.ZERO+minUnit;
        }else {
            return divide+maxUnit+inventory.divideAndRemainder(specQuantityB)[1]+minUnit;
        }
    }



}
