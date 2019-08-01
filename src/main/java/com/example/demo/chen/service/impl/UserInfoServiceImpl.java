package com.example.demo.chen.service.impl;

import com.example.demo.chen.entity.UserInfo;
import com.example.demo.chen.mapper.UserInfoMapper;
import com.example.demo.chen.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-01
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
