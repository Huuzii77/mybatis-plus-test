package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/31 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    /*@Autowired
    private UserMapper userMapper;
    @Autowired
    UserInfoService userInfoService;

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
//初始化返回类
        Map<String,Object> result = new HashMap<>();
        //查询年龄等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age = 18
        QueryWrapper<UserInfoEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(UserInfoEntity::getAge,18);
        List<UserInfoEntity> userInfoEntityList1 = userInfoService.list(queryWrapper1);
        result.put("studentAge18",userInfoEntityList1);
        System.out.println(result);
    }*/
}