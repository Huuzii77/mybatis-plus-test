package com.example.demo.chen.service.impl;

import com.example.demo.chen.entity.optional.City;
import com.example.demo.chen.entity.optional.Country;
import com.example.demo.chen.entity.optional.World;
import org.springframework.stereotype.Service;

/**
 * @author chendesheng
 * @create 2019/9/12 16:02
 */
@Service
public class OptionalServiceImpl {



    public String getAddress(World world){
        if (world != null){
            Country country = world.getCountry();
            if (country!=null){
                City city = country.getCity();
                if (city != null){
                    return city.getName();
                }
            }
        }

        return "UNKNOWN";
    }


}
