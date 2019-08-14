package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.chen.entity.Buy;
import com.example.demo.chen.entity.User;
import com.example.demo.chen.entity.UserInfo;
import com.example.demo.chen.mapper.BuyMapper;
import com.example.demo.chen.mapper.EmployeeMapper;
import com.example.demo.chen.mapper.UserInfoMapper;
import com.example.demo.chen.mapper.UserMapper;
import com.example.demo.chen.service.IEmployeeService;
import com.example.demo.chen.service.IUserInfoService;
import com.example.demo.chen.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/31 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    IUserService userService;
    @Autowired
    IUserInfoService userInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    BuyMapper buyMapper;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void testSelect() {

        System.out.println(("----- selectAll method test1 ------"));

        List<User> userList = userMapper.selectList(null);
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
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("更新测试");

        userMapper.updateById(user);//根据id进行更新，没传值的属性就更新为null
    }

    @Test
    public void testPage() {
        IPage<User> userList = userMapper.selectPage(new Page<>(1, 2), null);
        System.out.println(userList);
    }

    @Test
    public void testWrapper() {
        //初始化返回类
        Map<String, Object> result = new HashMap<>();
        //查询年龄等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age = 18
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(UserInfo::getName, "小明");
        List<UserInfo> userInfoEntityList = userInfoService.list(queryWrapper);
        result.put("studentAge18", userInfoEntityList);
        System.out.println(result);
    }

    @Test
    public void testUserInfoPage() {

        IPage<UserInfo> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().isNotNull(UserInfo::getEvaluate);

        page = userInfoService.page(page, queryWrapper);
        log.info("PAGE:{}", JSON.toJSONString(page));
        System.out.println(page);
    }

    @Test
    public void delete() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNotNull("name")
                .ge("age", 12);
        int delete = userInfoMapper.delete(queryWrapper);
        System.out.println(delete);

    }

    @Test
    public void page() {
        Page<UserInfo> page = new Page<>(1, 2);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        IPage<UserInfo> userInfoIPage = userInfoService.page(page, queryWrapper);
        log.info("Page:{}", JSON.toJSONString(userInfoIPage));
    }

    @Test
    public void fastJsonTest() {
        /*Buy buy = new Buy();
        buy.setName("xi");
        buy.setBuyTime(LocalDateTime.now());
        buyMapper.insert(buy);*/
        //JSON解析LocalDateTime成字符串和存到数据库是不带T的
        //QueryWrapper<Buy> queryWrapper = new QueryWrapper();
        //queryWrapper.lambda().isNotNull(Buy::getName);
        Buy buy = buyMapper.selectById(2);
        System.out.println(JSON.toJSONString(buy));
    }

    @Test
    public void testList() {
        int[] array = new int[6];
        Random random = new Random();
        for (int i = 1; i < array.length; i++) {
            boolean flag = false;

            array[0] = random.nextInt(10);
            int b=0;
            while (flag) {

                int a=0;
                b = random.nextInt(10);
                for (int j = 0; j < i; j++) {
                    if (array[j] != b) {
                        a++;
                    }
                }
                if (a==i){
                    flag=true;
                }

            }
            array[i]=b;

        }
        for (int z=0;z<array.length;z++){
            System.out.println(z);
        }



    }

    @Test
    public void test(){
        int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoneyWithOptimisticLock(1)).start();
        }
        /*int threadCount = 100;
        while (threadCount-- > 0) {
            new Thread(() -> employeeService.increaseMoneyWithPessimisticLock(1)).start();
        }*/
    }


}