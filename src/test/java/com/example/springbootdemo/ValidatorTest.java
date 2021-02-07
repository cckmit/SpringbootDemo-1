package com.example.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.bean.SkuPromotionDTO;
import com.example.springbootdemo.scheduled.bean.BaseTemp;
import com.example.springbootdemo.scheduled.bean.MessageDTO;
import com.example.springbootdemo.scheduled.bean.ProductSkuDTO;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.utils.TimeHandleUtils;
import com.example.springbootdemo.utils.ValidatorUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTest {

    public static final long TIME_MILLIS_HOUR = 3600000L;
    public static final long TIME_MILLIS_MINUTE = 60000L;
    public static final long TIME_MILLIS_DAY = 86400000L;

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
        System.out.println(BigDecimal.valueOf(199).compareTo(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(10))) <= 0);
        System.out.println(BigDecimal.valueOf(200).compareTo(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(10))) <= 0);
        System.out.println(BigDecimal.valueOf(201).compareTo(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(10))) <= 0);
    }

    @Test
    public void test03(){
        List<Long> productIds = Lists.newArrayList();
        productIds.addAll(null);
    }

    @Test
    public void test04(){

        System.out.println("清除昨日的数据:"+JSON.toJSONString(TimeHandleUtils.getYesDayEndTime()));

    }

    private static String transformInventoryMaxUnitName(BigDecimal inventory,Integer specQuantity,String minUnit,String maxUnit){
        inventory = ObjectUtils.defaultIfNull(inventory, BigDecimal.ZERO);
        BigDecimal specQuantityB = BigDecimal.valueOf(specQuantity);
        BigDecimal divide = inventory.divide(specQuantityB, 0, BigDecimal.ROUND_DOWN);
        if (inventory.divideAndRemainder(specQuantityB)[1].compareTo(BigDecimal.ZERO)==0){
            return divide+maxUnit+BigDecimal.ZERO+minUnit;
        }else {
            return divide+maxUnit+inventory.divideAndRemainder(specQuantityB)[1].setScale(0, BigDecimal.ROUND_UP)+minUnit;
        }
    }





}
