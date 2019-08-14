package com.example.demo.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.chen.entity.Employee;
import com.example.demo.chen.mapper.EmployeeMapper;
import com.example.demo.chen.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-14
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void increaseMoneyWithPessimisticLock(Integer id) {
        Employee employee = employeeMapper.findByIdWithPessimisticLock(id);
                 final Integer oldMoney = employee.getMoney();
                 log.info("oldMoney: {}", oldMoney);
                 employee.setMoney(oldMoney + 1);
                 employeeMapper.updateById(employee);
    }

    @Override
    public int updateEmployeeWithOptimisticLock(Integer id) {


        return 0;
    }

    @Override
    public Integer internalIncreaseMoneyWithOptimisticLock(Integer id) {

        Employee employee = employeeMapper.selectById(id);
        final Integer oldMoney = employee.getMoney();
        log.info("old money:{}",oldMoney);
        employee.setMoney(oldMoney+1);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Employee::getId,employee.getId());
        return employeeMapper.update(employee,queryWrapper);

    }

    @Override
    public void increaseMoneyWithOptimisticLock(Integer id) {
        int tryTimes = 0;
        while (true) {
            tryTimes++;
            if (internalIncreaseMoneyWithOptimisticLock(id) != 0) {
                // 说明更新成功，直接退出
                break;
            }
            if (tryTimes == 200) {
                // 达到最大重试次数，退出
                break;
            }
            try {
                // 休息一段时间后再重试
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        log.info("tryTimes: {}", tryTimes);
    }
}
