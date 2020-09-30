package com.example.springbootdemo.pattern.strategy.Handler;

import com.example.springbootdemo.pattern.strategy.dto.BaseOrderDTO;
import com.example.springbootdemo.pattern.strategy.dto.OrderBO;
import com.example.springbootdemo.pattern.strategy.dto.OrderDTO;
import com.example.springbootdemo.pattern.strategy.dto.OrderMetadata;
import com.example.springbootdemo.pattern.strategy.service.OrderService;
import com.example.springbootdemo.utils.SpringUtils;

import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-20
 **/
public abstract class AbstractHandler {

    protected abstract void add(BaseOrderDTO orderDTO);

    protected OrderService getInstance(Integer type){
        Map<Integer,Class> map = OrderProperties.getMap();
        return (OrderService)SpringUtils.getBean(map.get(type));
    }

    protected OrderMetadata getOrderMetadata(BaseOrderDTO orderDTO){
        OrderMetadata orderMetadata = new OrderMetadata();
        if (orderDTO.getType()==OrderProperties.ORDER_SIMP){
            orderMetadata.setOrderBO((OrderBO)orderDTO);
        }
        if (orderDTO.getType()==OrderProperties.ORDER_HANDLER){
            orderMetadata.setOrderDTO((OrderDTO)orderDTO);
        }
        return orderMetadata;
    }
}
