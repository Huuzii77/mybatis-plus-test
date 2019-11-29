package com.example.demo;

/**
 * @author chendesheng
 * @create 2019/9/16 17:20
 */
public class SimpleThread  implements  Runnable{

    @Override
    public void run() {

        Sample instance = Sample.getInstance();

        System.out.println(Thread.currentThread().getName()+" get instance "+instance);
    }
}
