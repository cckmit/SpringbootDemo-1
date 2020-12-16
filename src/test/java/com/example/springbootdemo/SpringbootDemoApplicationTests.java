package com.example.springbootdemo;

import com.example.springbootdemo.scheduled.dao.CouponActivityMapper;
import com.example.springbootdemo.scheduled.dao.ProductSkuDao;
import com.example.springbootdemo.utils.DingtalkRobotMessageUtils;
import com.google.common.cache.CacheLoader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootDemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ProductSkuDao productSkuDao;

    @Autowired
    private CouponActivityMapper couponActivityMapper;

    private static Map<String, StringBuffer> dealerInfoPushMap = new ConcurrentHashMap<>();

    static {

    }

    @Test
    void test(){
        List<Map> maps = productSkuDao.selectProductSkuList(null);
        Set<Map> collect = maps.stream().collect(Collectors.toSet());
    }

    @Test
    void redisTest() {
        redisTemplate.opsForValue().set("test","这是一条测试数据",30, TimeUnit.SECONDS);

    }



    @Test
    void Xtest1() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            taskExecutor.execute(()->{
                logger.info(String.valueOf(finalI));
            });
        }
        
    }

    @Test
    public void testCacheLoaderSupplier() throws Exception {
        Supplier<Long> supplier = new Supplier<Long>() {
            @Override
            public Long get() {
                //这里简单的返回时间戳
                return System.currentTimeMillis();
            }
        };
        CacheLoader<Object, Long> cacheLoader = CacheLoader.from(()->{
            return System.currentTimeMillis();
        });
        System.out.println(cacheLoader.load("first"));
        Thread.sleep(300);//这里线程休息下，方便测试
        System.out.println(cacheLoader.load("second"));


        Function<Date, String> function = new Function<Date, String>() {
            @Override
            public String apply(Date input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        };
        CacheLoader<Date, String> cacheLoader1 = CacheLoader.from((input)->{
            return new SimpleDateFormat("yyyy-MM-dd").format(input);
        });

        System.out.println(cacheLoader1.load(new Date()));
    }


}
