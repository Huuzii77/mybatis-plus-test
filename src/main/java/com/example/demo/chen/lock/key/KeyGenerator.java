package com.example.demo.chen.lock.key;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * key generator
 *
 * @author liuguanglei liuguanglei@tuhu.cn
 * @create 2019-08-14 13:37
 * @since JDK8
 */
public interface KeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    String getLockKey(ProceedingJoinPoint pjp);
}
