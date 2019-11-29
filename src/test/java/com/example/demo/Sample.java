package com.example.demo;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式
 * @author chendesheng
 * @create 2019/8/22 10:22
 */
public class Sample  implements Serializable {



    private static class SampleHolder{

        private static final Sample instance=new Sample();
    }



    private Object readResolve(){
        return getInstance();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("start main thread");
//
//        Thread thread1=new Thread(new SimpleThread());
//        Thread thread2=new Thread(new SimpleThread());
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("end main thread");



        SampleEnum sample=SampleEnum.INSTANCE;

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("singleton_file"));

        objectOutputStream.writeObject(sample);

        ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream("singleton_file"));

        SampleEnum readSample = (SampleEnum)objectInputStream.readObject();

        System.out.println(readSample==sample);






        Class clazz=SampleEnum.class;
        Constructor constructor=clazz.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        SampleEnum newInstance = (SampleEnum)constructor.newInstance("tony",99);
        System.out.println(sample==newInstance);







    }


    private Sample(){
        if (SampleHolder.instance!=null){
            throw new RuntimeException("禁止反射创建对象的实例");
        }
    }

    public static Sample getInstance(){


        return SampleHolder.instance;
    }

    public void Hello(){
        System.out.println("Hello");
    }

}

