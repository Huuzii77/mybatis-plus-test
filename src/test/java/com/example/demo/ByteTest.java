package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chendesheng
 * @create 2019/9/2 18:59
 */
public class ByteTest {

    public static void main(String[] args) {

        List<Snow> snow1 = Arrays.asList(
                new Crusty(),new Slush(),new Powder());

        Map<Integer,String> map = new TreeMap<>();
        map.put(1,"hello");
        map.put(5,"hello2");
        map.put(3,"hello2");
        System.out.println(map);

        ByteTest byteTest = new ByteTest();
        ByteTest.Hello hello = byteTest.getHello();
        hello.hello();
    }


    public Hello getHello(){
        return new Hello();
    }

    class Hello{
        public void hello(){
            System.out.println("Hello");
        }
    }

}


class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}
