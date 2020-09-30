package com.example.springbootdemo.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.core.types.RedisClientInfo;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * RedisClusterConnectionDelegate
 *
 * @author lifeng
 */
public class RedisClusterConnectionDelegate implements RedisClusterConnection {

    private static final Logger LOG = LoggerFactory.getLogger(RedisClusterConnection.class);

    private static final int MAX_VALUE_SIZE = 100 * 1024;

    private final RedisClusterConnection redisClusterConnection;

    public RedisClusterConnectionDelegate(RedisClusterConnection redisClusterConnection) {
        this.redisClusterConnection = redisClusterConnection;
    }

    @Override
    public String ping(RedisClusterNode node) {
        return redisClusterConnection.ping(node);
    }

    @Override
    public void bgReWriteAof(RedisClusterNode node) {
        redisClusterConnection.bgReWriteAof(node);
    }

    @Override
    public void bgSave(RedisClusterNode node) {
        redisClusterConnection.bgSave(node);
    }

    @Override
    public Long lastSave(RedisClusterNode node) {
        return redisClusterConnection.lastSave(node);
    }

    @Override
    public void save(RedisClusterNode node) {
        redisClusterConnection.save(node);
    }

    @Override
    public Long dbSize(RedisClusterNode node) {
        return redisClusterConnection.dbSize(node);
    }

    @Override
    public void flushDb(RedisClusterNode node) {
        redisClusterConnection.flushDb(node);
    }

    @Override
    public void flushAll(RedisClusterNode node) {
        redisClusterConnection.flushAll(node);
    }

    @Override
    public Properties info(RedisClusterNode node) {
        return redisClusterConnection.info(node);
    }

    @Override
    public Properties info(RedisClusterNode node, String section) {
        return redisClusterConnection.info(node, section);
    }

    @Override
    public Set<byte[]> keys(RedisClusterNode node, byte[] pattern) {
        return redisClusterConnection.keys(node, pattern);
    }

    @Override
    public byte[] randomKey(RedisClusterNode node) {
        return redisClusterConnection.randomKey(node);
    }

    @Override
    public void shutdown(RedisClusterNode node) {
        redisClusterConnection.shutdown(node);
    }

    @Override
    public List<String> getConfig(RedisClusterNode node, String pattern) {
        return redisClusterConnection.getConfig(node, pattern);
    }

    @Override
    public void setConfig(RedisClusterNode node, String param, String value) {
        redisClusterConnection.setConfig(node, param, value);
    }

    @Override
    public void resetConfigStats(RedisClusterNode node) {
        redisClusterConnection.resetConfigStats(node);
    }

    @Override
    public Long time(RedisClusterNode node) {
        return redisClusterConnection.time(node);
    }

    @Override
    public List<RedisClientInfo> getClientList(RedisClusterNode node) {
        return redisClusterConnection.getClientList(node);
    }

    @Override
    public void close() throws DataAccessException {
        redisClusterConnection.close();
    }

    @Override
    public boolean isClosed() {
        return redisClusterConnection.isClosed();
    }

    @Override
    public Object getNativeConnection() {
        return redisClusterConnection.getNativeConnection();
    }

    @Override
    public boolean isQueueing() {
        return redisClusterConnection.isQueueing();
    }

    @Override
    public boolean isPipelined() {
        return redisClusterConnection.isPipelined();
    }

    @Override
    public void openPipeline() {
        redisClusterConnection.openPipeline();
    }

    @Override
    public List<Object> closePipeline() throws RedisPipelineException {
        return redisClusterConnection.closePipeline();
    }

    @Override
    public RedisSentinelConnection getSentinelConnection() {
        return redisClusterConnection.getSentinelConnection();
    }

    @Override
    public Object execute(String command, byte[]... args) {
        return redisClusterConnection.execute(command, args);
    }

    @Override
    public Boolean exists(byte[] key) {
        return redisClusterConnection.exists(key);
    }

    @Override
    public Long del(byte[]... keys) {
        return redisClusterConnection.del(keys);
    }

    @Override
    public DataType type(byte[] key) {
        return redisClusterConnection.type(key);
    }

    @Override
    public Set<byte[]> keys(byte[] pattern) {
        return redisClusterConnection.keys(pattern);
    }

    @Override
    public Cursor<byte[]> scan(ScanOptions options) {
        return redisClusterConnection.scan(options);
    }

    @Override
    public byte[] randomKey() {
        return redisClusterConnection.randomKey();
    }

    @Override
    public void rename(byte[] oldName, byte[] newName) {
        redisClusterConnection.rename(oldName, newName);
    }

    @Override
    public Boolean renameNX(byte[] oldName, byte[] newName) {
        return redisClusterConnection.renameNX(oldName, newName);
    }

    @Override
    public Boolean expire(byte[] key, long seconds) {
        return redisClusterConnection.expire(key, seconds);
    }

    @Override
    public Boolean pExpire(byte[] key, long millis) {
        return redisClusterConnection.pExpire(key, millis);
    }

    @Override
    public Boolean expireAt(byte[] key, long unixTime) {
        return redisClusterConnection.expireAt(key, unixTime);
    }

    @Override
    public Boolean pExpireAt(byte[] key, long unixTimeInMillis) {
        return redisClusterConnection.pExpireAt(key, unixTimeInMillis);
    }

    @Override
    public Boolean persist(byte[] key) {
        return redisClusterConnection.persist(key);
    }

    @Override
    public Boolean move(byte[] key, int dbIndex) {
        return redisClusterConnection.move(key, dbIndex);
    }

    @Override
    public Long ttl(byte[] key) {
        return redisClusterConnection.ttl(key);
    }

    @Override
    public Long ttl(byte[] bytes, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public Long pTtl(byte[] key) {
        return redisClusterConnection.pTtl(key);
    }

    @Override
    public Long pTtl(byte[] bytes, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public List<byte[]> sort(byte[] key, SortParameters params) {
        return redisClusterConnection.sort(key, params);
    }

    @Override
    public Long sort(byte[] key, SortParameters params, byte[] storeKey) {
        return redisClusterConnection.sort(key, params, storeKey);
    }

    @Override
    public byte[] dump(byte[] key) {
        return redisClusterConnection.dump(key);
    }

    @Override
    public void restore(byte[] key, long ttlInMillis, byte[] serializedValue) {
        redisClusterConnection.restore(key, ttlInMillis, serializedValue);
    }

    @Override
    public byte[] get(byte[] key) {
        byte[] value = redisClusterConnection.get(key);
        int length = value.length;
        if (length > MAX_VALUE_SIZE) {
            LOG.warn("获取超大RedisKey：{}, 大小：{}", new String(key), length);
        }
        return value;
    }

    @Override
    public byte[] getSet(byte[] key, byte[] value) {
        return redisClusterConnection.getSet(key, value);
    }

    @Override
    public List<byte[]> mGet(byte[]... keys) {
        return redisClusterConnection.mGet(keys);
    }

    @Override
    public void set(byte[] key, byte[] value) {
        int length = value.length;
        if (length > MAX_VALUE_SIZE) {
            LOG.warn("设置超大RedisKey：{}, 大小：{}", new String(key), length);
        }
        redisClusterConnection.set(key, value);
    }

    @Override
    public void set(byte[] key, byte[] value, Expiration expiration, SetOption option) {
        int length = value.length;
        if (length > MAX_VALUE_SIZE) {
            LOG.warn("设置超大RedisKey：{}, 大小：{}", new String(key), length);
        }
        redisClusterConnection.set(key, value, expiration, option);
    }

    @Override
    public Boolean setNX(byte[] key, byte[] value) {
        return redisClusterConnection.setNX(key, value);
    }

    @Override
    public void setEx(byte[] key, long seconds, byte[] value) {
        redisClusterConnection.setEx(key, seconds, value);
    }

    @Override
    public void pSetEx(byte[] key, long milliseconds, byte[] value) {
        redisClusterConnection.pSetEx(key, milliseconds, value);
    }

    @Override
    public void mSet(Map<byte[], byte[]> tuple) {
        redisClusterConnection.mSet(tuple);
    }

    @Override
    public Boolean mSetNX(Map<byte[], byte[]> tuple) {
        return redisClusterConnection.mSetNX(tuple);
    }

    @Override
    public Long incr(byte[] key) {
        return redisClusterConnection.incr(key);
    }

    @Override
    public Long incrBy(byte[] key, long value) {
        return redisClusterConnection.incrBy(key, value);
    }

    @Override
    public Double incrBy(byte[] key, double value) {
        return redisClusterConnection.incrBy(key, value);
    }

    @Override
    public Long decr(byte[] key) {
        return redisClusterConnection.decr(key);
    }

    @Override
    public Long decrBy(byte[] key, long value) {
        return redisClusterConnection.decrBy(key, value);
    }

    @Override
    public Long append(byte[] key, byte[] value) {
        return redisClusterConnection.append(key, value);
    }

    @Override
    public byte[] getRange(byte[] key, long begin, long end) {
        return redisClusterConnection.getRange(key, begin, end);
    }

    @Override
    public void setRange(byte[] key, byte[] value, long offset) {
        redisClusterConnection.setRange(key, value, offset);
    }

    @Override
    public Boolean getBit(byte[] key, long offset) {
        return redisClusterConnection.getBit(key, offset);
    }

    @Override
    public Boolean setBit(byte[] key, long offset, boolean value) {
        return redisClusterConnection.setBit(key, offset, value);
    }

    @Override
    public Long bitCount(byte[] key) {
        return redisClusterConnection.bitCount(key);
    }

    @Override
    public Long bitCount(byte[] key, long begin, long end) {
        return redisClusterConnection.bitCount(key, begin, end);
    }

    @Override
    public Long bitOp(BitOperation op, byte[] destination, byte[]... keys) {
        return redisClusterConnection.bitOp(op, destination, keys);
    }

    @Override
    public Long strLen(byte[] key) {
        return redisClusterConnection.strLen(key);
    }

    @Override
    public Long rPush(byte[] key, byte[]... values) {
        return redisClusterConnection.rPush(key, values);
    }

    @Override
    public Long lPush(byte[] key, byte[]... values) {
        return redisClusterConnection.lPush(key, values);
    }

    @Override
    public Long rPushX(byte[] key, byte[] value) {
        return redisClusterConnection.rPushX(key, value);
    }

    @Override
    public Long lPushX(byte[] key, byte[] value) {
        return redisClusterConnection.lPushX(key, value);
    }

    @Override
    public Long lLen(byte[] key) {
        return redisClusterConnection.lLen(key);
    }

    @Override
    public List<byte[]> lRange(byte[] key, long begin, long end) {
        return redisClusterConnection.lRange(key, begin, end);
    }

    @Override
    public void lTrim(byte[] key, long begin, long end) {
        redisClusterConnection.lTrim(key, begin, end);
    }

    @Override
    public byte[] lIndex(byte[] key, long index) {
        return redisClusterConnection.lIndex(key, index);
    }

    @Override
    public Long lInsert(byte[] key, Position where, byte[] pivot, byte[] value) {
        return redisClusterConnection.lInsert(key, where, pivot, value);
    }

    @Override
    public void lSet(byte[] key, long index, byte[] value) {
        redisClusterConnection.lSet(key, index, value);
    }

    @Override
    public Long lRem(byte[] key, long count, byte[] value) {
        return redisClusterConnection.lRem(key, count, value);
    }

    @Override
    public byte[] lPop(byte[] key) {
        return redisClusterConnection.lPop(key);
    }

    @Override
    public byte[] rPop(byte[] key) {
        return redisClusterConnection.rPop(key);
    }

    @Override
    public List<byte[]> bLPop(int timeout, byte[]... keys) {
        return redisClusterConnection.bLPop(timeout, keys);
    }

    @Override
    public List<byte[]> bRPop(int timeout, byte[]... keys) {
        return redisClusterConnection.bRPop(timeout, keys);
    }

    @Override
    public byte[] rPopLPush(byte[] srcKey, byte[] dstKey) {
        return redisClusterConnection.rPopLPush(srcKey, dstKey);
    }

    @Override
    public byte[] bRPopLPush(int timeout, byte[] srcKey, byte[] dstKey) {
        return redisClusterConnection.bRPopLPush(timeout, srcKey, dstKey);
    }

    @Override
    public Long sAdd(byte[] key, byte[]... values) {
        return redisClusterConnection.sAdd(key, values);
    }

    @Override
    public Long sRem(byte[] key, byte[]... values) {
        return redisClusterConnection.sRem(key, values);
    }

    @Override
    public byte[] sPop(byte[] key) {
        return redisClusterConnection.sPop(key);
    }

    @Override
    public Boolean sMove(byte[] srcKey, byte[] destKey, byte[] value) {
        return redisClusterConnection.sMove(srcKey, destKey, value);
    }

    @Override
    public Long sCard(byte[] key) {
        return redisClusterConnection.sCard(key);
    }

    @Override
    public Boolean sIsMember(byte[] key, byte[] value) {
        return redisClusterConnection.sIsMember(key, value);
    }

    @Override
    public Set<byte[]> sInter(byte[]... keys) {
        return redisClusterConnection.sInter(keys);
    }

    @Override
    public Long sInterStore(byte[] destKey, byte[]... keys) {
        return redisClusterConnection.sInterStore(destKey, keys);
    }

    @Override
    public Set<byte[]> sUnion(byte[]... keys) {
        return redisClusterConnection.sUnion(keys);
    }

    @Override
    public Long sUnionStore(byte[] destKey, byte[]... keys) {
        return redisClusterConnection.sUnionStore(destKey, keys);
    }

    @Override
    public Set<byte[]> sDiff(byte[]... keys) {
        return redisClusterConnection.sDiff(keys);
    }

    @Override
    public Long sDiffStore(byte[] destKey, byte[]... keys) {
        return redisClusterConnection.sDiffStore(destKey, keys);
    }

    @Override
    public Set<byte[]> sMembers(byte[] key) {
        return redisClusterConnection.sMembers(key);
    }

    @Override
    public byte[] sRandMember(byte[] key) {
        return redisClusterConnection.sRandMember(key);
    }

    @Override
    public List<byte[]> sRandMember(byte[] key, long count) {
        return redisClusterConnection.sRandMember(key, count);
    }

    @Override
    public Cursor<byte[]> sScan(byte[] key, ScanOptions options) {
        return redisClusterConnection.sScan(key, options);
    }

    @Override
    public Boolean zAdd(byte[] key, double score, byte[] value) {
        return redisClusterConnection.zAdd(key, score, value);
    }

    @Override
    public Long zAdd(byte[] key, Set<Tuple> tuples) {
        return redisClusterConnection.zAdd(key, tuples);
    }

    @Override
    public Long zRem(byte[] key, byte[]... values) {
        return redisClusterConnection.zRem(key, values);
    }

    @Override
    public Double zIncrBy(byte[] key, double increment, byte[] value) {
        return redisClusterConnection.zIncrBy(key, increment, value);
    }

    @Override
    public Long zRank(byte[] key, byte[] value) {
        return redisClusterConnection.zRank(key, value);
    }

    @Override
    public Long zRevRank(byte[] key, byte[] value) {
        return redisClusterConnection.zRevRank(key, value);
    }

    @Override
    public Set<byte[]> zRange(byte[] key, long begin, long end) {
        return redisClusterConnection.zRange(key, begin, end);
    }

    @Override
    public Set<Tuple> zRangeWithScores(byte[] key, long begin, long end) {
        return redisClusterConnection.zRangeWithScores(key, begin, end);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, double min, double max) {
        return redisClusterConnection.zRangeByScore(key, min, max);
    }

    @Override
    public Set<Tuple> zRangeByScoreWithScores(byte[] key, Range range) {
        return redisClusterConnection.zRangeByScoreWithScores(key, range);
    }

    @Override
    public Set<Tuple> zRangeByScoreWithScores(byte[] key, double min, double max) {
        return redisClusterConnection.zRangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, double min, double max, long offset, long count) {
        return redisClusterConnection.zRangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zRangeByScoreWithScores(byte[] key, double min, double max, long offset, long count) {
        return redisClusterConnection.zRangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zRangeByScoreWithScores(byte[] key, Range range, Limit limit) {
        return redisClusterConnection.zRangeByScoreWithScores(key, range, limit);
    }

    @Override
    public Set<byte[]> zRevRange(byte[] key, long begin, long end) {
        return redisClusterConnection.zRevRange(key, begin, end);
    }

    @Override
    public Set<Tuple> zRevRangeWithScores(byte[] key, long begin, long end) {
        return redisClusterConnection.zRevRangeWithScores(key, begin, end);
    }

    @Override
    public Set<byte[]> zRevRangeByScore(byte[] key, double min, double max) {
        return redisClusterConnection.zRevRangeByScore(key, min, max);
    }

    @Override
    public Set<byte[]> zRevRangeByScore(byte[] key, Range range) {
        return redisClusterConnection.zRevRangeByScore(key, range);
    }

    @Override
    public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, double min, double max) {
        return redisClusterConnection.zRevRangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<byte[]> zRevRangeByScore(byte[] key, double min, double max, long offset, long count) {
        return redisClusterConnection.zRevRangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<byte[]> zRevRangeByScore(byte[] key, Range range, Limit limit) {
        return redisClusterConnection.zRevRangeByScore(key, range, limit);
    }

    @Override
    public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, double min, double max, long offset, long count) {
        return redisClusterConnection.zRevRangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, Range range) {
        return redisClusterConnection.zRevRangeByScoreWithScores(key, range);
    }

    @Override
    public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, Range range, Limit limit) {
        return redisClusterConnection.zRevRangeByScoreWithScores(key, range, limit);
    }

    @Override
    public Long zCount(byte[] key, double min, double max) {
        return redisClusterConnection.zCount(key, min, max);
    }

    @Override
    public Long zCount(byte[] key, Range range) {
        return redisClusterConnection.zCount(key, range);
    }

    @Override
    public Long zCard(byte[] key) {
        return redisClusterConnection.zCard(key);
    }

    @Override
    public Double zScore(byte[] key, byte[] value) {
        return redisClusterConnection.zScore(key, value);
    }

    @Override
    public Long zRemRange(byte[] key, long begin, long end) {
        return redisClusterConnection.zRemRange(key, begin, end);
    }

    @Override
    public Long zRemRangeByScore(byte[] key, double min, double max) {
        return redisClusterConnection.zRemRangeByScore(key, min, max);
    }

    @Override
    public Long zRemRangeByScore(byte[] key, Range range) {
        return redisClusterConnection.zRemRangeByScore(key, range);
    }

    @Override
    public Long zUnionStore(byte[] destKey, byte[]... sets) {
        return redisClusterConnection.zUnionStore(destKey, sets);
    }

    @Override
    public Long zUnionStore(byte[] destKey, Aggregate aggregate, int[] weights, byte[]... sets) {
        return redisClusterConnection.zUnionStore(destKey, aggregate, weights, sets);
    }

    @Override
    public Long zInterStore(byte[] destKey, byte[]... sets) {
        return redisClusterConnection.zInterStore(destKey, sets);
    }

    @Override
    public Long zInterStore(byte[] destKey, Aggregate aggregate, int[] weights, byte[]... sets) {
        return redisClusterConnection.zInterStore(destKey, aggregate, weights, sets);
    }

    @Override
    public Cursor<Tuple> zScan(byte[] key, ScanOptions options) {
        return redisClusterConnection.zScan(key, options);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, String min, String max) {
        return redisClusterConnection.zRangeByScore(key, min, max);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, Range range) {
        return redisClusterConnection.zRangeByScore(key, range);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, String min, String max, long offset, long count) {
        return redisClusterConnection.zRangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<byte[]> zRangeByScore(byte[] key, Range range, Limit limit) {
        return redisClusterConnection.zRangeByScore(key, range, limit);
    }

    @Override
    public Set<byte[]> zRangeByLex(byte[] key) {
        return redisClusterConnection.zRangeByLex(key);
    }

    @Override
    public Set<byte[]> zRangeByLex(byte[] key, Range range) {
        return redisClusterConnection.zRangeByLex(key, range);
    }

    @Override
    public Set<byte[]> zRangeByLex(byte[] key, Range range, Limit limit) {
        return redisClusterConnection.zRangeByLex(key, range, limit);
    }

    @Override
    public Boolean hSet(byte[] key, byte[] field, byte[] value) {
        return redisClusterConnection.hSet(key, field, value);
    }

    @Override
    public Boolean hSetNX(byte[] key, byte[] field, byte[] value) {
        return redisClusterConnection.hSetNX(key, field, value);
    }

    @Override
    public byte[] hGet(byte[] key, byte[] field) {
        return redisClusterConnection.hGet(key, field);
    }

    @Override
    public List<byte[]> hMGet(byte[] key, byte[]... fields) {
        return redisClusterConnection.hMGet(key, fields);
    }

    @Override
    public void hMSet(byte[] key, Map<byte[], byte[]> hashes) {
        redisClusterConnection.hMSet(key, hashes);
    }

    @Override
    public Long hIncrBy(byte[] key, byte[] field, long delta) {
        return redisClusterConnection.hIncrBy(key, field, delta);
    }

    @Override
    public Double hIncrBy(byte[] key, byte[] field, double delta) {
        return redisClusterConnection.hIncrBy(key, field, delta);
    }

    @Override
    public Boolean hExists(byte[] key, byte[] field) {
        return redisClusterConnection.hExists(key, field);
    }

    @Override
    public Long hDel(byte[] key, byte[]... fields) {
        return redisClusterConnection.hDel(key, fields);
    }

    @Override
    public Long hLen(byte[] key) {
        return redisClusterConnection.hLen(key);
    }

    @Override
    public Set<byte[]> hKeys(byte[] key) {
        return redisClusterConnection.hKeys(key);
    }

    @Override
    public List<byte[]> hVals(byte[] key) {
        return redisClusterConnection.hVals(key);
    }

    @Override
    public Map<byte[], byte[]> hGetAll(byte[] key) {
        return redisClusterConnection.hGetAll(key);
    }

    @Override
    public Cursor<Map.Entry<byte[], byte[]>> hScan(byte[] key, ScanOptions options) {
        return redisClusterConnection.hScan(key, options);
    }

    @Override
    public void multi() {
        redisClusterConnection.multi();
    }

    @Override
    public List<Object> exec() {
        return redisClusterConnection.exec();
    }

    @Override
    public void discard() {
        redisClusterConnection.discard();
    }

    @Override
    public void watch(byte[]... keys) {
        redisClusterConnection.watch(keys);
    }

    @Override
    public void unwatch() {
        redisClusterConnection.unwatch();
    }

    @Override
    public boolean isSubscribed() {
        return redisClusterConnection.isSubscribed();
    }

    @Override
    public Subscription getSubscription() {
        return redisClusterConnection.getSubscription();
    }

    @Override
    public Long publish(byte[] channel, byte[] message) {
        return redisClusterConnection.publish(channel, message);
    }

    @Override
    public void subscribe(MessageListener listener, byte[]... channels) {
        redisClusterConnection.subscribe(listener, channels);
    }

    @Override
    public void pSubscribe(MessageListener listener, byte[]... patterns) {
        redisClusterConnection.pSubscribe(listener, patterns);
    }

    @Override
    public void select(int dbIndex) {
        redisClusterConnection.select(dbIndex);
    }

    @Override
    public byte[] echo(byte[] message) {
        return redisClusterConnection.echo(message);
    }

    @Override
    public String ping() {
        return redisClusterConnection.ping();
    }

    @Override
    @Deprecated
    public void bgWriteAof() {
        redisClusterConnection.bgWriteAof();
    }

    @Override
    public void bgReWriteAof() {
        redisClusterConnection.bgReWriteAof();
    }

    @Override
    public void bgSave() {
        redisClusterConnection.bgSave();
    }

    @Override
    public Long lastSave() {
        return redisClusterConnection.lastSave();
    }

    @Override
    public void save() {
        redisClusterConnection.save();
    }

    @Override
    public Long dbSize() {
        return redisClusterConnection.dbSize();
    }

    @Override
    public void flushDb() {
        redisClusterConnection.flushDb();
    }

    @Override
    public void flushAll() {
        redisClusterConnection.flushAll();
    }

    @Override
    public Properties info() {
        return redisClusterConnection.info();
    }

    @Override
    public Properties info(String section) {
        return redisClusterConnection.info(section);
    }

    @Override
    public void shutdown() {
        redisClusterConnection.shutdown();
    }

    @Override
    public void shutdown(ShutdownOption option) {
        redisClusterConnection.shutdown(option);
    }

    @Override
    public List<String> getConfig(String pattern) {
        return redisClusterConnection.getConfig(pattern);
    }

    @Override
    public void setConfig(String param, String value) {
        redisClusterConnection.setConfig(param, value);
    }

    @Override
    public void resetConfigStats() {
        redisClusterConnection.resetConfigStats();
    }

    @Override
    public Long time() {
        return redisClusterConnection.time();
    }

    @Override
    public void killClient(String host, int port) {
        redisClusterConnection.killClient(host, port);
    }

    @Override
    public String getClientName() {
        return redisClusterConnection.getClientName();
    }

    @Override
    public void setClientName(byte[] name) {
        redisClusterConnection.setClientName(name);
    }

    @Override
    public List<RedisClientInfo> getClientList() {
        return redisClusterConnection.getClientList();
    }

    @Override
    public void slaveOf(String host, int port) {
        redisClusterConnection.slaveOf(host, port);
    }

    @Override
    public void slaveOfNoOne() {
        redisClusterConnection.slaveOfNoOne();
    }

    @Override
    public void migrate(byte[] key, RedisNode target, int dbIndex, MigrateOption option) {
        redisClusterConnection.migrate(key, target, dbIndex, option);
    }

    @Override
    public void migrate(byte[] key, RedisNode target, int dbIndex, MigrateOption option, long timeout) {
        redisClusterConnection.migrate(key, target, dbIndex, option, timeout);
    }

    @Override
    public void scriptFlush() {
        redisClusterConnection.scriptFlush();
    }

    @Override
    public void scriptKill() {
        redisClusterConnection.scriptKill();
    }

    @Override
    public String scriptLoad(byte[] script) {
        return redisClusterConnection.scriptLoad(script);
    }

    @Override
    public List<Boolean> scriptExists(String... scriptShas) {
        return redisClusterConnection.scriptExists(scriptShas);
    }

    @Override
    public <T> T eval(byte[] script, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
        return redisClusterConnection.eval(script, returnType, numKeys, keysAndArgs);
    }

    @Override
    public <T> T evalSha(String scriptSha, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
        return redisClusterConnection.evalSha(scriptSha, returnType, numKeys, keysAndArgs);
    }

    @Override
    public <T> T evalSha(byte[] scriptSha, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
        return redisClusterConnection.evalSha(scriptSha, returnType, numKeys, keysAndArgs);
    }

    @Override
    public Long pfAdd(byte[] key, byte[]... values) {
        return redisClusterConnection.pfAdd(key, values);
    }

    @Override
    public Long pfCount(byte[]... keys) {
        return redisClusterConnection.pfCount(keys);
    }

    @Override
    public void pfMerge(byte[] destinationKey, byte[]... sourceKeys) {
        redisClusterConnection.pfMerge(destinationKey, sourceKeys);
    }

    @Override
    public Iterable<RedisClusterNode> clusterGetNodes() {
        return redisClusterConnection.clusterGetNodes();
    }

    @Override
    public Collection<RedisClusterNode> clusterGetSlaves(RedisClusterNode master) {
        return redisClusterConnection.clusterGetSlaves(master);
    }

    @Override
    public Map<RedisClusterNode, Collection<RedisClusterNode>> clusterGetMasterSlaveMap() {
        return redisClusterConnection.clusterGetMasterSlaveMap();
    }

    @Override
    public Integer clusterGetSlotForKey(byte[] key) {
        return redisClusterConnection.clusterGetSlotForKey(key);
    }

    @Override
    public RedisClusterNode clusterGetNodeForSlot(int slot) {
        return redisClusterConnection.clusterGetNodeForSlot(slot);
    }

    @Override
    public RedisClusterNode clusterGetNodeForKey(byte[] key) {
        return redisClusterConnection.clusterGetNodeForKey(key);
    }

    @Override
    public ClusterInfo clusterGetClusterInfo() {
        return redisClusterConnection.clusterGetClusterInfo();
    }

    @Override
    public void clusterAddSlots(RedisClusterNode node, int... slots) {
        redisClusterConnection.clusterAddSlots(node, slots);
    }

    @Override
    public void clusterAddSlots(RedisClusterNode node, RedisClusterNode.SlotRange range) {
        redisClusterConnection.clusterAddSlots(node, range);
    }

    @Override
    public Long clusterCountKeysInSlot(int slot) {
        return redisClusterConnection.clusterCountKeysInSlot(slot);
    }

    @Override
    public void clusterDeleteSlots(RedisClusterNode node, int... slots) {
        redisClusterConnection.clusterDeleteSlots(node, slots);
    }

    @Override
    public void clusterDeleteSlotsInRange(RedisClusterNode node, RedisClusterNode.SlotRange range) {
        redisClusterConnection.clusterDeleteSlotsInRange(node, range);
    }

    @Override
    public void clusterForget(RedisClusterNode node) {
        redisClusterConnection.clusterForget(node);
    }

    @Override
    public void clusterMeet(RedisClusterNode node) {
        redisClusterConnection.clusterMeet(node);
    }

    @Override
    public void clusterSetSlot(RedisClusterNode node, int slot, AddSlots mode) {
        redisClusterConnection.clusterSetSlot(node, slot, mode);
    }

    @Override
    public List<byte[]> clusterGetKeysInSlot(int slot, Integer count) {
        return redisClusterConnection.clusterGetKeysInSlot(slot, count);
    }

    @Override
    public void clusterReplicate(RedisClusterNode master, RedisClusterNode slave) {
        redisClusterConnection.clusterReplicate(master, slave);
    }

    @Override
    public Long geoAdd(byte[] bytes, Point point, byte[] bytes1) {
        return null;
    }

    @Override
    public Long geoAdd(byte[] bytes, GeoLocation<byte[]> geoLocation) {
        return null;
    }

    @Override
    public Long geoAdd(byte[] bytes, Map<byte[], Point> map) {
        return null;
    }

    @Override
    public Long geoAdd(byte[] bytes, Iterable<GeoLocation<byte[]>> iterable) {
        return null;
    }

    @Override
    public Distance geoDist(byte[] bytes, byte[] bytes1, byte[] bytes2) {
        return null;
    }

    @Override
    public Distance geoDist(byte[] bytes, byte[] bytes1, byte[] bytes2, Metric metric) {
        return null;
    }

    @Override
    public List<String> geoHash(byte[] bytes, byte[]... bytes1) {
        return null;
    }

    @Override
    public List<Point> geoPos(byte[] bytes, byte[]... bytes1) {
        return null;
    }

    @Override
    public GeoResults<GeoLocation<byte[]>> geoRadius(byte[] bytes, Circle circle) {
        return null;
    }

    @Override
    public GeoResults<GeoLocation<byte[]>> geoRadius(byte[] bytes, Circle circle, GeoRadiusCommandArgs geoRadiusCommandArgs) {
        return null;
    }

    @Override
    public GeoResults<GeoLocation<byte[]>> geoRadiusByMember(byte[] bytes, byte[] bytes1, double v) {
        return null;
    }

    @Override
    public GeoResults<GeoLocation<byte[]>> geoRadiusByMember(byte[] bytes, byte[] bytes1, Distance distance) {
        return null;
    }

    @Override
    public GeoResults<GeoLocation<byte[]>> geoRadiusByMember(byte[] bytes, byte[] bytes1, Distance distance, GeoRadiusCommandArgs geoRadiusCommandArgs) {
        return null;
    }

    @Override
    public Long geoRemove(byte[] bytes, byte[]... bytes1) {
        return null;
    }
}
