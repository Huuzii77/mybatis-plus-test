package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.mapper.UserInfoDao;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/31 22:59
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
}
