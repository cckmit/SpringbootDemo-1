package com.example.springbootdemo.pattern.strategy.serviceimpl;

import com.example.springbootdemo.pattern.strategy.Handler.OrderProperties;
import com.example.springbootdemo.pattern.strategy.annotation.OrderHandlerType;
import com.example.springbootdemo.pattern.strategy.dto.OrderBO;
import com.example.springbootdemo.pattern.strategy.dto.OrderMetadata;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Service
@OrderHandlerType(OrderProperties.ORDER_SIMP)
public class OrderSimpServiceImpl extends AbstractOrderManager {

    @Override
    public void addOrder(OrderMetadata orderMetadata) {
        OrderBO bo = orderMetadata.getOrderBO();
        System.out.println("处理Id为"+bo.getOrderId()+"的普通订单");
    }

    @Override
    public void updateOrder(OrderMetadata orderMetadata) {
        System.out.println("updateOrder--->处理普通订单");
    }
}
