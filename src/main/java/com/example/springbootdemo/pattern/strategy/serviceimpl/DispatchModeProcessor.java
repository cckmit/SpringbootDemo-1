package com.example.springbootdemo.pattern.strategy.serviceimpl;

import com.example.springbootdemo.pattern.strategy.Handler.AbstractHandler;
import com.example.springbootdemo.pattern.strategy.dto.BaseOrderDTO;
import com.example.springbootdemo.pattern.strategy.service.OrderService;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Component
public class DispatchModeProcessor extends AbstractHandler {


    @Override
    public void add(BaseOrderDTO orderDTO) {
        OrderService orderService = getInstance(orderDTO.getType());

        /**
         * 订单完结广播通知(1 - 支付完成)
         */
        orderService.addOrder(getOrderMetadata(orderDTO));

    }
}