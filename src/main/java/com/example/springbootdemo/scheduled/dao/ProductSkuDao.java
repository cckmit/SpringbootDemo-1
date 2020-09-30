package com.example.springbootdemo.scheduled.dao;

import com.example.springbootdemo.scheduled.bean.ProductSkuDTO;
import com.example.springbootdemo.scheduled.bean.StatisticalGroupDTO;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;


/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-16
 **/
public interface ProductSkuDao {

    /**
     * 获取 店铺下面所有的sku
     * @return
     */
    Page<Map> selectProductSkuList(Map map);
    void insertProductSku(ProductSkuDTO productSkuDTO);


    /**
     * 查询统计分组字典DDDDD
     * @return
     */
    List<StatisticalGroupDTO> selectStatisticalGroup(List<String> list);
}
