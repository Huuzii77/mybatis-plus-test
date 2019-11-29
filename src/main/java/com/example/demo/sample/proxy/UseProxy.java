package com.example.demo.sample.proxy;

import java.lang.reflect.Proxy;

/**
 * @author chendesheng
 * @create 2019/9/25 18:31
 */
public class UseProxy {
    public static void main(String[] args) {
        IHelloWorld helloWorld = new HelloWorld();
        LoggerHandler handler = new LoggerHandler(helloWorld);
        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(
          Thread.currentThread().getContextClassLoader(),
                helloWorld.getClass().getInterfaces(),handler);
        proxy.sayHello();
    }
}
