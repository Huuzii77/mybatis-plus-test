package com.example.demo.chen.controller;

import com.example.demo.chen.annotation.LocalLock;
import com.example.demo.chen.service.LocalLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 锁
 * @authir chendesheng
 * @create 2019/8/14 15:41
 */
@RestController
@RequestMapping("/test")
public class LocalLockController {
    @Autowired
    LocalLockService localLockService;

    /**
     * 本地锁
     * @param token
     * @return
     */
    @LocalLock(key = "key:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "success - " + token;
    }


    /**
     * redis分布式锁
     * @param key
     * @param val
     * @return
     */
    @GetMapping("/set/{key}/{val}")
    public boolean set(@PathVariable String key, @PathVariable String val) {

        return  localLockService.setnx(key,val);

    }




}
