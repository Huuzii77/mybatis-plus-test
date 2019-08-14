package com.example.demo.chen.mapper;

import com.example.demo.chen.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-14
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /***
     * 悲观锁
     * @param id
     * @return
     */
    Employee findByIdWithPessimisticLock(Integer id);
}
