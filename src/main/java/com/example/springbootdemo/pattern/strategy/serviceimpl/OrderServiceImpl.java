package com.example.springbootdemo.pattern.strategy.serviceimpl;

import com.example.springbootdemo.pattern.strategy.dto.OrderDTO;
import com.example.springbootdemo.pattern.strategy.service.IOrderService;

/**
 * @program: springboot-demo
 * @description: 策略模式使用之前
 * @author: swd
 * @create: 2020-08-20
 **/
public class OrderServiceImpl implements IOrderService {
    @Override
    public String handle(OrderDTO dto) {

      /*  String type = dto.getType();
        if ("1".equals(type)) {
            return "处理普通订单";
        } else if ("2".equals(type)) {
            return "处理团购订单";
        } else if ("3".equals(type)) {
            return "处理促销订单";
        }
        return null;*/
      return null;
    }
}
