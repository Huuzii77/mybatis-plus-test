package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/7/31 14:16
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;
}
