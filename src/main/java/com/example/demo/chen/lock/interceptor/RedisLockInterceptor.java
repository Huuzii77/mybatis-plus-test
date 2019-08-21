package com.example.demo.chen.lock.interceptor;


import com.example.demo.chen.lock.annotation.RedisLock;
import com.example.demo.chen.lock.key.KeyGenerator;
import com.example.demo.chen.lock.util.RedisLockUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author liuguanglei liuguanglei@tuhu.cn
 * @create 2019-08-14 13:39
 * @since JDK8
 */
@Aspect
@Configuration
@Slf4j
public class RedisLockInterceptor {

    @Autowired
    public RedisLockInterceptor(RedisLockUtils redisLockUtils, KeyGenerator keyGenerator) {
        this.redisLockUtils = redisLockUtils;
        this.keyGenerator = keyGenerator;
    }

    private final RedisLockUtils redisLockUtils;
    private final KeyGenerator keyGenerator;


    @Around("execution(public * *(..)) && @annotation(com.example.demo.chen.lock.annotation.RedisLock)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        final Object[] args = proceedingJoinPoint.getArgs();
        Integer orderId=0;
        if(null!=args&&args.length==1){
            System.out.println(args.toString());
        }
        RedisLock lock = method.getAnnotation(RedisLock.class);
        if (StringUtils.isEmpty(lock.prefix())) {
            log.error("redis key prefix not be null");
            throw new RuntimeException("redis key prefix not be null");
        }
        final String lockKey = keyGenerator.getLockKey(proceedingJoinPoint);
        String value = UUID.randomUUID().toString();
        try {
            // 假设上锁成功，但是设置过期时间失效，以后拿到的都是 false
            final boolean success = redisLockUtils.lock(lockKey,value, lock.expire(), lock.timeUnit());
            if (!success) {
                log.error("在指定的时间:{}毫秒内，接口方法:{}被重复提交",lock.expire(),method.getName());
                throw new RuntimeException("在指定的时间间隔"+lock.expire()+"毫秒内接口方法:"+method.getName()+"被重复请求");
            }
            try {
                return proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                log.error("DO派单系统【分布式锁拦截器】异常{},订单号:{}",throwable,orderId);
                throw new RuntimeException("DO派单系统【分布式锁拦截器】异常",throwable);
            }
        } finally {

            log.info("DO派单系统【分布式锁拦截器】解锁  key {} value {}",lockKey,value);
            redisLockUtils.unlock(lockKey, value);

        }
    }
}
