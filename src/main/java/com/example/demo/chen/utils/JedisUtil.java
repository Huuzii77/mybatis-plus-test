package com.example.demo.chen.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis工具类
 * @authir chendesheng
 * @create 2019/8/14 16:39
 */
public class JedisUtil {


    private static JedisPool jedisPool;


    /*创建连接池*/
    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxWaitMillis(1000*10);
        jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
    }

    /**
     * 获取jedis
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 关闭Jedis
     * @param jedis
     */
    public static void close(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
}
