package com.example.demo;

/**
 * 工厂方法模式
 *
 * @author chendesheng
 * @create 2019/9/17 10:00
 */
public interface FruitFactory {

    Fruit getFruit();

}


class AppleFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}

class BananaFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}



class FactoryTest {

    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.getFruit();
        fruit.eat();
    }

}