package com.example.demo.chen.design.template;

/**
 * @author chendesheng
 * @create 2019/8/21 11:04
 */
public class HousingClient {

    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();
        // using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }

}
