package com.example.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.exception.CustomException;
import com.example.springbootdemo.scheduled.bean.ProductSkuDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-06
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {

    @Test
    public void test01() {
        ProductSkuDTO p1 = new ProductSkuDTO();
        p1.setId(1L);
        ProductSkuDTO p2 = new ProductSkuDTO();
        p1.setId(2L);

        List<ProductSkuDTO> list1 = null;
        List<ProductSkuDTO> list2 = Collections.singletonList(p1);

        List<Long> collect = Optional.ofNullable(list1).map(List::stream).orElseGet(Stream::empty).map(ProductSkuDTO::getId).collect(Collectors.toList());

        //ifPresent
        Optional.ofNullable(list1).ifPresent(dto -> {
            log.info(JSON.toJSONString(dto));
        });

        //orElseThrow
        Optional.ofNullable(list2).orElseThrow(() ->
                new CustomException("11")
        );

        //filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
        Optional.ofNullable(list2).filter((list) ->
                list.contains(p1)
        ).ifPresent(list -> {
            log.info(JSON.toJSONString(list));
        });

        //map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        Optional.ofNullable(list2).map(list ->
                list.add(p2)
        ).ifPresent(e -> {
            log.info(JSON.toJSONString(e));
        });


    }
    @Test
    public void test02(){
        for (int i = 0; i < 20; i++) {
            int r = (int)(Math.random()*10);
            System.out.println(r);
        }
    }


}
