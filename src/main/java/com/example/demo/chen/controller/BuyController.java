package com.example.demo.chen.controller;


import com.example.demo.chen.entity.Buy;
import com.example.demo.chen.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-02
 */
@RestController
@RequestMapping("/chen/buy")
public class BuyController {

    @Autowired
    IBuyService buyService;


    @PostMapping("/test1")
    public boolean test1(@RequestBody Buy buy) {

        try {
            buyService.testTransaction(buy);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    @GetMapping("/test2")
    public boolean test2() {
        buyService.testTransaction2();
        return true;
    }

    @GetMapping("/test3")
    public boolean test3() {
        buyService.testTransaction3();
        return true;
    }

    @GetMapping("/test4")
    public boolean test4() {
        buyService.testTransaction4();
        return true;
    }
}
