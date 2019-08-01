package com.example.demo.chen.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @TableId中可以决定主键的类型,不写会采取默认值,默认值可以在yml中配置
     * AUTO: 数据库ID自增
     * INPUT: 用户输入ID
     * ID_WORKER: 全局唯一ID，Long类型的主键
     * ID_WORKER_STR: 字符串全局唯一ID
     * UUID: 全局唯一ID，UUID类型的主键
     * NONE: 该类型为未设置主键类型
     */
    @TableId(type = IdType.AUTO)
    @JSONField(serialize = false)
    private Integer id;

    /**
     * 姓名
     */
    @JSONField(name = "firstName")
    private String name;

    /**
     * 购买日期
     * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") Jackson包使用注解
     * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  格式化前台日期参数注解
     * @JSONField(pattern = "yyyy-MM-dd HH:mm:ss")  FastJson包使用注解
     */
    @JSONField(format = "yyyy-MM-dd")
    private LocalDateTime buyTime;


}
