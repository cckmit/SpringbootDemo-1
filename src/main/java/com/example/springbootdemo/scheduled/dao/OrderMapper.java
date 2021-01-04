package com.example.springbootdemo.scheduled.dao;

import com.example.springbootdemo.scheduled.bean.OrderQuery;

import java.util.Set;

/**
 * 订单 OrderMapper
 *
 * @Author: zhangmaodian
 * @Date: 2019/08/29 15:22
 */
public interface OrderMapper {


    /**
     * 查询最近时间范围内的店铺id
     * @param orderQuery
     * @return
     */
    Set<String> queryOrdersShopIds(OrderQuery orderQuery);

}
