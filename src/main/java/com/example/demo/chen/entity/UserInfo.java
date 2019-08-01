package com.example.demo.chen.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-01
 */
@Data
@Accessors(chain = true)
public class UserInfo{

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 技能
     */
    private String skill;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 分数
     */
    private Long fraction;


}
