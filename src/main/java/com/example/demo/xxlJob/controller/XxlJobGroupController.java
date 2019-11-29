package com.example.demo.xxlJob.controller;


import com.example.demo.xxlJob.entity.XxlJobGroup;
import com.example.demo.xxlJob.service.IXxlJobGroupService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chendesheng
 * @since 2019-09-30
 */
@RestController
@RequestMapping("/xxlJob/xxl-job-group")
@Slf4j
public class XxlJobGroupController {


    @Autowired
    IXxlJobGroupService xxlJobGroupService;
    @RequestMapping("/getInfo")
    @ApiOperation(value = "获取任务信息",notes = "参数为userId")
    public XxlJobGroup getInfo(@RequestParam Long id){
        XxlJobGroup xxlJobGroup = xxlJobGroupService.getById(id);
        return xxlJobGroup;
    }

    @RequestMapping("/getList")
    @ApiOperation(value = "获取所有用户信息")
    public List<XxlJobGroup> getList(){
        List<XxlJobGroup> xxlJobGroupList = xxlJobGroupService.list();
        log.info("search all userInfo result:{}",xxlJobGroupList);
        return xxlJobGroupList;
    }
}
