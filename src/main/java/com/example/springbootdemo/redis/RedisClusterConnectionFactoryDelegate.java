package com.example.springbootdemo.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;

/**
 * RedisClusterConnectionFactoryDelegate
 *
 * @author lifeng
 */
public class RedisClusterConnectionFactoryDelegate implements RedisConnectionFactory {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisClusterConnectionFactoryDelegate(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public RedisConnection getConnection() {
        return redisConnectionFactory.getConnection();
    }

    @Override
    public RedisClusterConnection getClusterConnection() {
        return new RedisClusterConnectionDelegate(redisConnectionFactory.getClusterConnection());
    }

    @Override
    public boolean getConvertPipelineAndTxResults() {
        return redisConnectionFactory.getConvertPipelineAndTxResults();
    }

    @Override
    public RedisSentinelConnection getSentinelConnection() {
        return redisConnectionFactory.getSentinelConnection();
    }

    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
        return redisConnectionFactory.translateExceptionIfPossible(ex);
    }

}
