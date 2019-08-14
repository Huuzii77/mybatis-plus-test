package com.example.demo.chen.annotation;

/**
 * @authir chendesheng
 * @create 2019/8/14 15:36
 */

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    String key() default "";

}
