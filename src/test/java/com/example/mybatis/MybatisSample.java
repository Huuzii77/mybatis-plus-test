package com.example.mybatis;

import com.example.demo.chen.entity.User;
import com.example.demo.chen.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chendesheng
 * @create 2019/9/17 14:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisSample {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void getSqlSessionFactory(){
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void selectUser(){
        SqlSession  session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectById(4);
            System.out.println(user);
            User user2 = userMapper.selectById(4);
            System.out.println(user2);
        } finally {
            session.close();
        }

    }
}
