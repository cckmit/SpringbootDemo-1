package com.example.springbootdemo.pattern.strategy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Data
public class MessageBean implements Serializable {
    private static final long serialVersionUID = 5454831432308782668L;
    private String cachKey;
    private List<Integer> type;
    private String orderBO;

    public MessageBean(List<Integer> type, String orderBO) {
        this.type = type;
        this.orderBO = orderBO;
    }
}
