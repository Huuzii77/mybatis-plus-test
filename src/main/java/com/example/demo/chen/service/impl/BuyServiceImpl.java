package com.example.demo.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.chen.entity.Buy;
import com.example.demo.chen.mapper.BuyMapper;
import com.example.demo.chen.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
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
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

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
            Buy happy = buyMapper.selectById(34);
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


    @Override
    public void testTransaction4() {
        TransactionStatus transactionStatus=null;
        boolean isCommit = false;
        try {
            transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            Buy buy = new Buy();
            buy.setName("happy");
            buy.setBuyTime(LocalDateTime.now());
            buyMapper.insert(buy);
            Buy happy = buyMapper.selectById(24);
            System.out.println("happy:"+happy.getName());
            //手动提交
            dataSourceTransactionManager.commit(transactionStatus);
            isCommit = true;
            System.out.println("手动提交事物成功!");
            throw new Exception("模拟第二个异常!");

        }catch (Exception ex){
            //如果未提交就进行回滚
            if(!isCommit){
                System.out.println("发生异常,进行手动回滚！");
                //手动回滚事物
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            ex.printStackTrace();
        }

    }
}