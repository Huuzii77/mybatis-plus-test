package com.example.demo.chen.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.chen.entity.OrdVehicle;
import com.example.demo.chen.service.impl.OrdVehicleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chendesheng
 * @create 2019/9/30 10:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrdVehicleMapperTest {

    @Autowired
    OrdVehicleMapper ordVehicleMapper;
    @Autowired
    OrdVehicleServiceImpl ordVehicleService;


    @Test
    public void getInfo(){
        IPage<OrdVehicle> page = new Page<>(1,501);
        IPage<OrdVehicle> ordVehicleList = ordVehicleService.page(page);
        log.info("result:{}",ordVehicleList.getRecords());
    }

}