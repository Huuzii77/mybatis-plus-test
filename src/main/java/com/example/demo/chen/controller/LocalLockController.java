package com.example.demo.chen.controller;

import com.example.demo.chen.annotation.LocalLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authir chendesheng
 * @create 2019/8/14 15:41
 */
@RestController
@RequestMapping("/test")
public class LocalLockController {

    @LocalLock(key = "key:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "success - " + token;
    }
}
