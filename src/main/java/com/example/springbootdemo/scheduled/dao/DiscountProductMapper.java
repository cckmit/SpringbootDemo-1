package com.example.springbootdemo.scheduled.dao;

import com.example.springbootdemo.scheduled.bean.DiscountProductPO;

import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-11-27
 **/
public interface DiscountProductMapper {

    /**
     * 批量修改限购规则id
     * @param list
     * @return
     */
    int batchUpdateDiscountProductLimitId(List<DiscountProductPO> list);
}
