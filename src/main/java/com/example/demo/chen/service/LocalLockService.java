package com.example.demo.chen.service;

/**
 * @authir chendesheng
 * @create 2019/8/14 16:21
 */
public interface LocalLockService {

    boolean setnx(String key,String val);
}
