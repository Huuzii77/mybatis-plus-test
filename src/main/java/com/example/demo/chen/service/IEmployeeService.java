package com.example.demo.chen.service;

import com.example.demo.chen.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-14
 */

public interface IEmployeeService extends IService<Employee> {

    /**
     * 悲观锁更新money
     * @param id
     */
    void increaseMoneyWithPessimisticLock(Integer id);

    int updateEmployeeWithOptimisticLock(Integer id);

    Integer internalIncreaseMoneyWithOptimisticLock(Integer id);

    void increaseMoneyWithOptimisticLock(Integer id);
}
