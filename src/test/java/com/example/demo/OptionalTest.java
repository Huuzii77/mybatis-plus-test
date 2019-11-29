package com.example.demo;

import com.example.demo.chen.entity.User;
import com.example.demo.chen.entity.optional.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author chendesheng
 * @create 2019/9/11 16:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OptionalTest {

    @Test
    public void test(){
        User user = new User(1L,"chen",12,"CHEN@qq.amil");
        String email = Optional.ofNullable(user).map(User::getEmail).orElse("hello");
        System.out.println(email);

        Optional<User> user1 = Optional.ofNullable(user).filter(user2 -> user2.getEmail()!=null && user2.getEmail().contains("@"));
        System.out.println(user1.isPresent());

    }



    public void filterCity(City city){

        Optional<City> real = Optional.ofNullable(city);
        real.filter(c -> c!=null && "ShangHai"
                .equals(c.getName()))
                .ifPresent(x -> System.out.println("ok"));

    }




}
