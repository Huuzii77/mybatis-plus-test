package com.example.demo;

import java.lang.reflect.Method;

/**
 * @author chendesheng
 * @create 2019/9/10 14:07
 */
public class DumpMethods {

    public static void main(String args[]) {
        try {
            Class c = Class.forName("java.util.Stack");

            Method m[] = c.getDeclaredMethods();

            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        }
        catch (Throwable e){
            System.err.println(e);
        }
    }

}
