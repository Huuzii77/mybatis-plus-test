package com.example.demo.chen.sample;

/**
 * @author chendesheng
 * @create 2019/9/18 17:20
 */
public class Apple extends Fruit {

    @Override
    public void color(){

    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        String user = apple.eat("chen");
        System.out.println(user);

    }
}
