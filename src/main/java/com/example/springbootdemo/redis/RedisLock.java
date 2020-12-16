package com.example.springbootdemo.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: springboot-demo
 * @description: 基于redis的分布式锁
 * @author: swd
 * @create: 2020-12-16
 **/
public class RedisLock {

    /**
     * 加锁lua.
     */
    private static final String ACQUIRE_LOCK = "if redis.call('exists', KEYS[1]) == 0 then \n"
            + " return redis.call('setex', KEYS[1], unpack(ARGV))  \n" + " end ";
    public static final String OK = "OK";
    /**
     * 解锁lua.
     */
    private static final String RELEASE_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then \n"
            + " return redis.call('del', KEYS[1]) or true \n" + "end";
    /**
     * 请求锁超时时间.
     */
    private long acquireTimeout;
    /**
     * 锁标识.
     */
    private String identifier;

    /**
     * 锁名.
     */
    private String lockName;

    /**
     * 锁定超时时间.
     */
    private long lockTimeout;

    private RedisTemplate<String, String> redisTemplate;

    /**
     * 锁构造方法.
     *
     * @param redisTemplate  redisTemplate
     * @param lockName       锁名
     * @param acquireTimeout 请求锁超时时间 单位秒
     * @param lockTimeout    锁定超时时间（防止死锁） 单位秒
     */
    public RedisLock(RedisTemplate<String, String> redisTemplate, String lockName, long acquireTimeout,
                     long lockTimeout) {
        this.redisTemplate = redisTemplate;
        this.lockName = "lock:" + lockName;
        this.acquireTimeout = acquireTimeout * 1000;
        this.lockTimeout = lockTimeout;
        this.identifier = UUID.randomUUID().toString();
    }

    /**
     * 获取锁.
     */
    public String acquireLock() {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                Jedis jedis = (Jedis) connection.getNativeConnection();
                List<String> keys = new ArrayList<String>(1);
                keys.add(lockName);
                List<String> args = new ArrayList<String>(2);
                args.add(Long.toString(lockTimeout));
                args.add(identifier);
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
            }
        });
    }

    public long getAcquireTimeout() {
        return acquireTimeout;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getLockName() {
        return lockName;
    }

    public long getLockTimeout() {
        return lockTimeout;
    }

    /**
     * 释放锁.
     */
    public void releaseLock() {
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                Jedis jedis = (Jedis) connection.getNativeConnection();
                List<String> keys = new ArrayList<>(1);
                keys.add(lockName);
                List<String> args = new ArrayList<>(1);
                args.add(identifier);
                jedis.eval(RELEASE_LOCK, keys, args);
                return null;
            }
        });

    }
}
