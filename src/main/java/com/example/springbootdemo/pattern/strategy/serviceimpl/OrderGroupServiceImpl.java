package com.example.springbootdemo.pattern.strategy.serviceimpl;

import com.example.springbootdemo.pattern.strategy.Handler.OrderProperties;
import com.example.springbootdemo.pattern.strategy.annotation.OrderHandlerType;
import com.example.springbootdemo.pattern.strategy.dto.OrderDTO;
import com.example.springbootdemo.pattern.strategy.dto.OrderMetadata;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Service
@OrderHandlerType(OrderProperties.ORDER_HANDLER)
public class OrderGroupServiceImpl extends AbstractOrderManager {

    @Override
    public void addOrder(OrderMetadata orderMetadata) {
        OrderDTO dto = orderMetadata.getOrderDTO();
        System.out.println("处理Id为"+dto.getOrderId()+"的团购订单");
    }

    @Override
    public void updateOrder(OrderMetadata orderMetadata) {
        System.out.println("updateOrder--->处理团购订单");
    }
}
