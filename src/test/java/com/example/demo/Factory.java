package com.example.demo;

/**
 * 简单工厂模式
 * @author chendesheng
 * @create 2019/9/17 9:44
 */
public class Factory {

    public static Fruit createFruit(String type){

        switch (type) {
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "litchi":
                return new Litchi();
            case "orange":
                return new Orange();
            default:
                return null;
        }
    }



    public static Fruit createFruit(Class clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Fruit) Class.forName(clazz.getName()).newInstance();
    }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fruit fruit = Factory.createFruit(Banana.class);
        fruit.eat();
    }


}


interface Fruit{
    void eat();
}


class Apple implements Fruit {
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Banana implements Fruit {
    public void eat() {
        System.out.println("吃香蕉");
    }
}

class Litchi implements Fruit {
    public void eat() {
        System.out.println("吃荔枝");
    }
}

class Orange implements Fruit {
    public void eat() {
        System.out.println("吃橘子");
    }
}