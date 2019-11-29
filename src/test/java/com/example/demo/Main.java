package com.example.demo;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/**
 * @description
 * @create 2019/8/12 21:13
 */
public class Main {

    class Hello{
        private String name;
        public String sayHello(String name){
            return "hello"+name;
        }
    }
    class what extends Hello{

    }




    public static void main(String[] args) {

        /**
         * 生成6个不重复、1-10之间的随机数字，用数组存储
         */


        int[] numbers = new int[6];
        Random random = new Random(88);

        for (int i = 0; i < numbers.length; i++) {

            boolean flag = true;
            while (flag) {
                int number = random.nextInt(10);

                flag = checkExists(numbers, number);
                if (flag == true) {
                    i--;
                    break;
                } else {
                    numbers[i] = number;
                }


            }

        }


        out.println(Arrays.toString(numbers));


    }

    public static boolean checkExists(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }
}
