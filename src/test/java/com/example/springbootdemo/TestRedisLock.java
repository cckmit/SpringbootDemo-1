package com.example.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: springboot-demo
 * @description: redis + lua 实现分布式锁
 * @author: swd
 * @create: 2020-12-16
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisLock {

    /**
     * 加锁lua.
     */
    private static final String ACQUIRE_LOCK = "if redis.call('exists', KEYS[1]) == 0 then \n"
            + " return redis.call('setex', KEYS[1], unpack(ARGV))  \n" + " end ";
    /**
     * 解锁lua.
     */
    private static final String RELEASE_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then \n"
            + " return redis.call('del', KEYS[1]) or true \n" + "end";

    public static final String OK = "OK";


    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void test04() {
        long acquireTimeout = 1000;
        String value = UUID.randomUUID().toString();

        String execute = redisTemplate.execute((RedisCallback<String>) connection -> {
            Jedis jedis = (Jedis) connection.getNativeConnection();
            List<String> keys = new ArrayList<String>(1);
            keys.add("testLockName");
            List<String> args = new ArrayList<String>(2);
            args.add(Long.toString(10));
            args.add(value);
            long end = System.currentTimeMillis() + acquireTimeout;
            while (System.currentTimeMillis() < end) {
                String acquire = (String) jedis.eval(ACQUIRE_LOCK, keys, args);
                if (null != acquire && acquire.equals(OK)) {
                    return OK;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            return null;
        });
        System.out.println(execute);



        redisTemplate.execute((RedisCallback<Void>) connection -> {
            Jedis jedis = (Jedis) connection.getNativeConnection();
            List<String> keys = new ArrayList<>(1);
            keys.add("testLockName");
            List<String> args = new ArrayList<>(1);
            args.add(value);
            jedis.eval(RELEASE_LOCK, keys, args);
            return null;
        });
    }

}
