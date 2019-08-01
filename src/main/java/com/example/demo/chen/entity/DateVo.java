package com.example.demo.chen.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @desc
 * @create 2019/8/1 21:27
 */
@Data
public class DateVo {

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;


}
