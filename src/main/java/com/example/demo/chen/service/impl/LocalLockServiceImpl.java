package com.example.demo.chen.service.impl;

import com.example.demo.chen.service.LocalLockService;
import com.example.demo.chen.utils.JedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Redis分布式锁实践
 * @authir chendesheng
 * @create 2019/8/14 16:21
 */
@Service
public class LocalLockServiceImpl implements LocalLockService {


    @Override
    public boolean setnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            if (null==jedis){
                return false;
            }
            return jedis.set(key,val,"NX","PX",1000*6).equalsIgnoreCase("ok");

        } catch (Exception e) {

            e.printStackTrace();

        }finally {
            if (jedis!=null){
                jedis.close();
            }

        }
        return false;
    }




}
