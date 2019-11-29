package com.example.demo;

/**
 * 抽象工厂模式
 * @author chendesheng
 * @create 2019/9/17 10:09
 */
public class abstractFactory {

    public static void main(String[] args) {
        IFruitFactory factory=new allFactory();
        Apple apple=(Apple) factory.createApple();
        apple.eat();
    }

}
interface IFruitFactory{
    Fruit createApple();
    Fruit createBanana();
    Fruit createLitchi();
    Fruit createOrange();
}
class allFactory implements IFruitFactory{

    @Override
    public Fruit createApple() {
        return new Apple();
    }

    @Override
    public Fruit createBanana() {
        return new Banana();
    }

    @Override
    public Fruit createLitchi() {
        return new Litchi();
    }

    @Override
    public Fruit createOrange() {
        return new Orange();
    }
}
