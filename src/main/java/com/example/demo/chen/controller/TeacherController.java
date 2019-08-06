package com.example.demo.chen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.chen.entity.Teacher;
import com.example.demo.chen.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chendesheng
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/chen/teacher")
public class TeacherController {


    @Autowired
    ITeacherService teacherService;

    @PostMapping("/findAllByPage")
    public IPage<Teacher> findAllByPage(){
        Page<Teacher> page = new Page<>(1,1);
        return teacherService.page(page);
    }


}
