package com.example.springbootdemo.pattern.strategy.dto;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Data
public class OrderMetadata {

    private OrderBO orderBO;
    private OrderDTO orderDTO;
}
