package com.example.springbootdemo.Annotation;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.redis.RedisLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AutoCacheAspect {

	private static Logger logger = LogManager.getLogger(AutoCacheAspect.class);

	@Resource
	protected RedisTemplate redisTemplate;
	
	@Around("@annotation(around)")
	public Object round(ProceedingJoinPoint point, AutoCache around){
		String cacheKey = getKey(point, around);
		//开启缓存后的读取全局锁，避免缓存击穿,锁等待时间3秒,过期时间20分钟
		RedisLock redisLock = new RedisLock(redisTemplate,cacheKey, 3,1200);
		Object result = redisTemplate.opsForValue().get(cacheKey);
		logger.info("获取缓存中的数据:{},key:{}",JSON.toJSONString(result),cacheKey);
		if (!StringUtils.isEmpty(result)) {
		    if ("NULL".equals(result)) {
		        result = null;
		    }
		    return result;
		}
		String state = redisLock.acquireLock();
        logger.info("获取锁对象:{}",state);
        if (RedisLock.OK.equals(state)) {
            try {
                result = redisTemplate.opsForValue().get(cacheKey);
                if (!StringUtils.isEmpty(result)) {
                    if ("NULL".equals(result)) {
                        result = null;
                    }
                    return result;
                }
                result = point.proceed();
            } catch (Throwable e) {
                logger.info("缓存方法执行异常------",e);
                throw new RuntimeException(e.getMessage());
            } finally {
                if (StringUtils.isEmpty(result)) {
                    //使用null字段代替null值避免缓存穿透
                    redisTemplate.opsForValue().set(cacheKey, "NULL", around.timeOut(),TimeUnit.SECONDS);
                } else {
                    logger.info("缓存key:{},缓存参数:{},缓存时间s:{}",cacheKey,JSON.toJSONString(result),around.timeOut());
                    //使用小范围随机时间避免缓存雪崩
                    redisTemplate.opsForValue().set(cacheKey, result, around.timeOut()+(int) Math.round(Math.random() * 360),TimeUnit.SECONDS);
                }
                redisLock.releaseLock();
            }
        }
		return result;
	}

	/**
	 * redis key的生成策略
	 * 例:YJX-GatewayActivityProductService-testCache:[{"shopId":"7233598257074368970"}],缓存参数:{"brandName":"伊利"},缓存时间ms:3600000
	 * @param point
	 * @param around
	 * @return
	 */
	private String getKey(ProceedingJoinPoint point, AutoCache around) {
		//配置的参数
		String service = around.service();
		StringBuilder sb = new StringBuilder();
		sb.append(service);
		sb.append(point.getTarget().getClass().getSimpleName());
		sb.append("-");
		sb.append(point.getSignature().getName());
		sb.append(":");
		sb.append(JSON.toJSONString(point.getArgs()));
		return sb.toString();
	}

}
