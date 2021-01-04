package com.example.springbootdemo;

import com.example.springbootdemo.bean.SkuPromotionDTO;
import com.example.springbootdemo.scheduled.bean.DiscountProductPO;
import com.example.springbootdemo.scheduled.bean.OrderQuery;
import com.example.springbootdemo.scheduled.bean.StatisticalGroupDTO;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.scheduled.dao.DiscountProductMapper;
import com.example.springbootdemo.scheduled.dao.OrderMapper;
import com.example.springbootdemo.scheduled.dao.ProductSkuDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.util.MetaObjectUtil;
import com.google.common.collect.Lists;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-09-04
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private ProductSkuDao productSkuDao;

    @Autowired
    private DiscountProductMapper discountProductMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test01(){
        Map param = new HashMap();
        param.put("pageSize",20);
        param.put("pageNum",2);
        param.put("countSql",false);
        Page<Map> maps1 = productSkuDao.selectProductSkuList(param);
        System.out.println(maps1.getTotal());
//        List<Map> maps = productSkuDao.selectSynStockList(param);
    }

    @Test
    public void test02(){
        MetaObject paramsObject = null;
        Map param = new HashMap();
        param.put("pageSize",20);
        param.put("pageNum",2);
        param.put("count",false);
        param.put("countSql",false);
        Object params = param;
        paramsObject = MetaObjectUtil.forObject(params);
        ObjectWrapper objectWrapper = new MapWrapper(paramsObject,param);
        System.out.println(productSkuDao.getClass().getSimpleName());
        System.out.println(paramsObject.hasGetter("countSql"));
    }

    @Test
    public void test03(){
        Temp temp = new Temp();
        temp.setMax(1);
        Temp temp1 = new Temp();
        temp1.setTest("2");
        BeanUtils.copyProperties(temp,temp1);
        System.out.println(temp1);
    }


    @Test
    public void test04(){
        List<StatisticalGroupDTO> statisticalGroupList= productSkuDao.selectStatisticalGroup(Lists.newArrayList("3396"));
        Optional<StatisticalGroupDTO> first = statisticalGroupList.stream().filter(statisticalGroupDTO -> 6 == statisticalGroupDTO.getStatisticalGroup()).findFirst();
        System.out.println(first.isPresent());

    }

    @Test
    public void test05(){
        DiscountProductPO po1 = new DiscountProductPO();
        po1.setId(170597830560335742L);
        po1.setJpLimitId(1);
        DiscountProductPO po2 = new DiscountProductPO();
        po2.setId(170597830560335840L);
        po2.setJpLimitId(2);
        ArrayList<DiscountProductPO> discountProductPOS = Lists.newArrayList(po1, po2);
        discountProductMapper.batchUpdateDiscountProductLimitId(discountProductPOS);

    }


    @Test
    public void test06(){
        SkuPromotionDTO skuPromotion=new SkuPromotionDTO();
        skuPromotion.setShopId("123456");
        skuPromotion.setBeginTime(new Date());
        skuPromotion.setEndTime(new Date());
        skuPromotion.setProductSkuId("2134679");
        List<String> discountProductList = discountProductMapper.getDiscountProductList(skuPromotion);

    }

    @Test
    public void test07(){
        OrderQuery orderQuery =new OrderQuery();
        orderQuery.setOrderCreateStartTime("2020-10-01");
        Set<String> set = orderMapper.queryOrdersShopIds(orderQuery);
    }

    @Test
    public void test08(){
        ArrayList<OrderQuery> orderQueries =null;
        ArrayList<String> dealerIdList = Lists.newArrayList("1");
//        List<OrderQuery> itemList = orderQueries.stream().filter(p -> p.getContact() != null && dealerIdList.contains(String.valueOf(p.getContact()))).collect(Collectors.toList());
        List<OrderQuery> collect = Optional.ofNullable(orderQueries).map(List::stream).orElseGet(Stream::empty).filter(p -> p.getContact() != null && dealerIdList.contains(String.valueOf(p.getContact()))).collect(Collectors.toList());

    }
}
