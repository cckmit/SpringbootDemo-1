package com.example.springbootdemo.pattern.strategy.service;

import com.example.springbootdemo.pattern.strategy.dto.OrderDTO;

/**
 * @program: springboot-demo
 * @description:策略模式使用之前
 * @author: swd
 * @create: 2020-08-20
 **/
public interface IOrderService {
    String handle(OrderDTO dto);
}
