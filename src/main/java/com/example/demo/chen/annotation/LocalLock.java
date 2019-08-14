package com.example.demo.chen.annotation;

import java.lang.annotation.*;

/**
 * 本地锁注解
 * @author chendesheng
 * @create 2019/8/14 15:36
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    String key() default "";

}
