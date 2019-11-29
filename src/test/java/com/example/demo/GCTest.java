package com.example.demo;

/**
 * @author chendesheng
 * @create 2019/9/9 14:51
 */
public class GCTest {



    public static void main(String[] args) {
        System.out.println("GCTest's ClassLoader is " + GCTest.class.getClassLoader());
        System.out.println("The Parent of GCTest's ClassLoader is " + GCTest.class.getClassLoader().getParent());
        System.out.println("The GrandParent of GCTest's ClassLoader is " + GCTest.class.getClassLoader().getParent().getParent());
    }

}
