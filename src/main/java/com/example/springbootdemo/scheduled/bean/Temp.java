package com.example.springbootdemo.scheduled.bean;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-30
 **/
@Data
public class Temp extends BaseTemp{

    //@YjxBaseConstraint(identity = 1,checkColumn = {"test","max"})
    private Integer identity;
    private Long productSkuId;

    private String test;


    private Integer max;

    @Valid
    private List<ProductSkuDTO> list;

    /**
     * 活动价格
     */
    private BigDecimal promotionPrice;
}
