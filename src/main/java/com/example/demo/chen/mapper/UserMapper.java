package com.example.demo.chen.mapper;

import com.example.demo.chen.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2019-08-01
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询出users
     * @param ids
     * @return
     */
    List<User> selectUsers(List<Integer> ids);



}
