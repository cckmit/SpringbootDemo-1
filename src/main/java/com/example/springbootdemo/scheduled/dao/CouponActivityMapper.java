package com.example.springbootdemo.scheduled.dao;


import com.example.springbootdemo.scheduled.bean.CouponActivityListDTO;
import com.example.springbootdemo.scheduled.bean.CouponActivityQuery;

import java.util.List;

/**
 * @program: easysale-saas
 * @description: 券mapper
 * @author: swd
 * @create: 2020-05-24
 **/
public interface CouponActivityMapper {
    /**
     * 查询优惠券列表
     * @param query
     * @return
     */
    List<CouponActivityListDTO> selectCouponActivityList(CouponActivityQuery query);

}
