package com.example.demo.chen.lock.annotation;

import java.lang.annotation.*;

/**
 * @author liuguanglei liuguanglei@tuhu.cn
 * @create 2019-08-14 13:35
 * @since JDK8
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLockParam {
    /**
     * 字段名称
     *
     * @return String
     */
    String name() default "";
}
