package com.example.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/31 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {

        System.out.println(("----- selectAll method test1 ------"));

        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("chen");
        user.setAge(14);
        user.setEmail("chen@tuhu.cn");
        userMapper.insert(user);
        System.out.println(user.getId());

    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setName("更新测试");

        userMapper.updateById(user);//根据id进行更新，没传值的属性就更新为null
    }

    @Test
    public void testPage(){
        IPage<User> userList = userMapper.selectPage(new Page<>(1,2),null);
        System.out.println(userList);
    }

    @Test
    public void testWrapper(){

    }
}