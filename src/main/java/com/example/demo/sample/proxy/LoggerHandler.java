package com.example.demo.sample.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chendesheng
 * @create 2019/9/25 18:27
 */
@Slf4j
public class LoggerHandler implements InvocationHandler {

    private Object target;

    public LoggerHandler(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("start");
        Object result = method.invoke(target,args);
        log.info("end");

        return result;
    }
}
