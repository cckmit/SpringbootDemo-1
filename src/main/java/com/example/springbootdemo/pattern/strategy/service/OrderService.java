package com.example.springbootdemo.pattern.strategy.service;

import com.example.springbootdemo.pattern.strategy.dto.OrderMetadata;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
public interface OrderService {
    void addOrder(OrderMetadata orderMetadata);
    void updateOrder(OrderMetadata orderMetadata);
}
