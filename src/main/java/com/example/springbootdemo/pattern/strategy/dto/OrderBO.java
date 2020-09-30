package com.example.springbootdemo.pattern.strategy.dto;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description:策略模式使用之前
 * @author: swd
 * @create: 2020-08-20
 **/
@Data
public class OrderBO extends BaseOrderDTO{

    String orderId;
}
