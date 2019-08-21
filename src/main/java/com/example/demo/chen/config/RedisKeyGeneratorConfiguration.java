package com.example.demo.chen.config;


import com.example.demo.chen.lock.key.KeyGenerator;
import com.example.demo.chen.lock.key.RedisKeyKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CacheKeyGeneratorConfiguration
 *
 * @author liuguanglei liuguanglei@tuhu.cn
 * @create 2019-08-14 14:47
 * @since JDK8
 */
@Configuration
public class RedisKeyGeneratorConfiguration {


    @Bean
    public KeyGenerator cacheKeyGenerator(){

        return new RedisKeyKeyGenerator();
    }
}
