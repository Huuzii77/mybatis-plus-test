package com.example.demo.chen.service.impl;

import com.example.demo.chen.entity.User;
import com.example.demo.chen.mapper.UserMapper;
import com.example.demo.chen.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2019-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
