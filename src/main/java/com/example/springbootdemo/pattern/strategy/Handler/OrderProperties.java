package com.example.springbootdemo.pattern.strategy.Handler;

import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
public class OrderProperties {

    private OrderProperties(){}

    private static Map<Integer,Class> map;

    public static final int ORDER_HANDLER = 2;

    public static final int ORDER_SIMP = 1;


    public static Map<Integer, Class> getMap() {
        return map;
    }

    public static void of(Map<Integer, Class> map1) {
        OrderProperties.map = map1;
    }
}
