package com.example.demo.chen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 派单车辆信息
 * </p>
 *
 * @author chendesheng
 * @since 2019-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrdVehicle implements Serializable {

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
    private Integer id;
    /**
     * 派单订单ID
     */
    private Long dispatchOrderId;

    /**
     * 车型编码
     */
    @TableField("tId")
    private String tId;

    /**
     * VIN
     */
    @TableField("VIN")
    private String vin;

    private String plateNumber;

    /**
     * 客户车型
     */
    private String vehicleModel;

    /**
     * 车系
     */
    private String vehicleSeries;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;


}
