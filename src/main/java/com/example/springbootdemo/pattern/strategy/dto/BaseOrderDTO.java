package com.example.springbootdemo.pattern.strategy.dto;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Data
public class BaseOrderDTO {
    /**
     * 1.普通订单,2.团购订单,3.促销订单
     */
    Integer type;
}
