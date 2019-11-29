package com.example.demo;

/**
 * 单例模式
 * @author chendesheng
 * @create 2019/9/16 19:52
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return singleton;
    }


}
