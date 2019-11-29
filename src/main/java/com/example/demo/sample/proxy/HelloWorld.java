package com.example.demo.sample.proxy;

/**
 * @author chendesheng
 * @create 2019/9/25 18:25
 */
interface IHelloWorld{
    void sayHello();
}
public class HelloWorld implements IHelloWorld{

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}
