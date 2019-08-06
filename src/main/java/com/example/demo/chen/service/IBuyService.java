package com.example.demo.chen.service;

import com.example.demo.chen.entity.Buy;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-02
 */
public interface IBuyService extends IService<Buy> {
    /**
     * 测试事务
     * @param buy
     */
    void testTransaction(Buy buy);

    /**
     * 测试事务手动回滚
     */
    void testTransaction2();

    /**
     * 调用子方法回滚
     */
    void testTransaction3();
}
