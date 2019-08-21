package com.example.demo.chen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.chen.entity.UserInfo;
import com.example.demo.chen.lock.annotation.RedisLock;
import com.example.demo.chen.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-01
 */
@RestController
@RequestMapping("/chen/user-info")
@Slf4j
public class UserInfoController{
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 根据ID获取用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:34
     * @Param  userId  用户ID
     * @Return UserInfo 用户实体
     */
    @RequestMapping("/getInfo")
    public UserInfo getInfo(String userId){
        UserInfo UserInfo = userInfoService.getById(userId);
        return UserInfo;
    }
    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfo> 用户实体集合
     */
    @RedisLock(prefix = "mybatis.plus.test",expire =3000)
    @RequestMapping("/getList")
    public List<UserInfo> getList(){
        List<UserInfo> UserInfoList = userInfoService.list();
        log.info("search all userInfo result:{}",UserInfoList);
        return UserInfoList;
    }
    /**
     * 分页查询全部数据
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return IPage<UserInfo> 分页数据
     */
    @RequestMapping("/getInfoListPage")
    public IPage<UserInfo> getInfoListPage(){
        //需要在Config配置类中配置分页插件
        IPage<UserInfo> page = new Page<>();
        page.setCurrent(5);
        page.setSize(1);
        page = userInfoService.page(page);
        return page;
    }
    /**
     * 根据指定字段查询用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/8 16:39
     * @Return Collection<UserInfo> 用户实体集合
     */
    @RequestMapping("/getListMap")
    public Collection<UserInfo> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<UserInfo> UserInfoList = userInfoService.listByMap(map);
        return UserInfoList;
    }
    /**
     * 新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:40
     */
    @RequestMapping("/saveInfo")
    public void saveInfo(){
        UserInfo UserInfo = new UserInfo();
        UserInfo.setName("小龙");
        UserInfo.setSkill("JAVA");
        UserInfo.setAge(18);
        UserInfo.setFraction(59L);
        UserInfo.setEvaluate("该学生是一个在改BUG的码农");
        userInfoService.save(UserInfo);
    }
    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @RequestMapping("/saveInfoList")
    public void saveInfoList(){
        //创建对象
        UserInfo sans = new UserInfo();
        sans.setName("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfo papyrus = new UserInfo();
        papyrus.setName("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfo> list =new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userInfoService.saveBatch(list);
    }
    /**
     * 更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:47
     */
    @RequestMapping("/updateInfo")
    public void updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfo UserInfo = new UserInfo();
        UserInfo.setId(1L);
        UserInfo.setAge(19);
        userInfoService.updateById(UserInfo);
    }
    /**
     * 新增或者更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:50
     */
    @RequestMapping("/saveOrUpdateInfo")
    public void saveOrUpdate(){
        //传入的实体类UserInfo中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfo UserInfo = new UserInfo();
        UserInfo.setId(1L);
        UserInfo.setAge(20);
        userInfoService.saveOrUpdate(UserInfo);
    }
    /**
     * 根据ID删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:52
     */
    @RequestMapping("/deleteInfo")
    public void deleteInfo(String userId){
        userInfoService.removeById(userId);
    }
    /**
     * 根据ID批量删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:55
     */
    @RequestMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        userInfoService.removeByIds(userIdlist);
    }
    /**
     * 根据指定字段删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:57
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        userInfoService.removeByMap(map);
    }
    

}
