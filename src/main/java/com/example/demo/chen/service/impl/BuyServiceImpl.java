package com.example.demo.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.chen.entity.Buy;
import com.example.demo.chen.mapper.BuyMapper;
import com.example.demo.chen.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-02
 */
@Service
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy> implements IBuyService {

    @Autowired
    BuyMapper buyMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void testTransaction(Buy buy) {
        buyMapper.insert(buy);
        int a=1/0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void testTransaction2() {

        try {
            Buy buy = new Buy();
            buy.setName("happy");
            buy.setBuyTime(LocalDateTime.now());
            buyMapper.insert(buy);
            Buy happy = buyMapper.selectById(14);
            System.out.println("happy:"+happy.getName());
        } catch (Exception e) {
            System.out.println("发生异常,进行手动回滚！");
            // 手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void testTransaction3() {
        Buy buy = new Buy();
        buy.setName("happy");
        buy.setBuyTime(LocalDateTime.now());
        buyMapper.insert(buy);
        this.getBuy();
    }


    public void getBuy(){
        Buy happy = buyMapper.selectById(24);
        System.out.println("happy:"+happy.getName());
    }
}