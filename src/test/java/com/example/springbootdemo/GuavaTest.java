package com.example.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.scheduled.bean.ProductSkuDTO;
import com.example.springbootdemo.scheduled.bean.Temp;
import com.example.springbootdemo.utils.DateUtil;
import com.example.springbootdemo.utils.DateUtils;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-14
 **/
@SpringBootTest
public class GuavaTest {

    @Test
    public void test01() {
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
        Predicate<String> allCaps = new Predicate<String>() {
            public boolean apply(String string) {
                return CharMatcher.javaUpperCase().matchesAllOf(string);
            }
        };
        ArrayList<String> strings = Lists.newArrayList("111","111","222","333");
        List<String> collect = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        //数据统计的set
        Multiset<Integer> lengths = HashMultiset.create(Iterables.transform(Iterables.filter(strings, allCaps), lengthFunction));
        System.out.println(lengths);

        //相同的key values自动汇成list集合
        Multimap<String,Integer> map = ArrayListMultimap.create();
        map.put("aa", 1);
        System.out.println(map.get("aa")); //[1, 2]
    }

    @org.junit.Test
    public void test02() {
        int diffDays = DateUtils.getDiffDays(DateUtil.stringParseToDate("2020-06-14 00:00:00"), DateUtil.stringParseToDate("2020-08-14 00:00:00"));
        System.out.println(diffDays);

    }

    @org.junit.Test
    public void test03() {
        Temp temp1 = new Temp();
        temp1.setMax(10);
        Temp temp2 = new Temp();
        temp2.setMax(20);
        ArrayList<Temp> temps = Lists.newArrayList(temp1, temp2);

        ArrayList<ProductSkuDTO> objects = Lists.newArrayList();
        temps.forEach(e->{
            ProductSkuDTO productSkuDTO = new ProductSkuDTO();
            productSkuDTO.setId(e.getMax().longValue());
            objects.add(productSkuDTO);
        });


        objects.forEach(e->{
            e.setProductSkuId(300L);
        });

        System.out.println(JSON.toJSONString(objects));


    }

    @org.junit.Test
    public void test04(){
        //获取两个月份之间的月份
        List<String> yyyyMM = DateUtils.getMonths(DateUtil.stringParseToDate("202006","yyyyMM"), DateUtil.stringParseToDate("202008","yyyyMM"), "yyyyMM");
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));
    }


    @org.junit.Test
    public void test05(){
        BigDecimal numberOfLargeUnits = BigDecimal.valueOf(19.3);
        System.out.println( numberOfLargeUnits.compareTo(BigDecimal.valueOf(20))>=0);



    }
}
