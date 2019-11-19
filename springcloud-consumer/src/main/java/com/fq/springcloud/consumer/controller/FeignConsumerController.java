package com.fq.springcloud.consumer.controller;

import com.fq.springcloud.consumer.service.FeignDeptService;
import com.fq.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qianfang, at 2019-11-14, 08:59
 **/
@RestController
public class FeignConsumerController {

    @Autowired
    private FeignDeptService deptService;


    @RequestMapping("feign/dept/findAll")
    public List<Dept> findAll() {
        System.out.println("findAll");
        return deptService.findAll();
    }

    @RequestMapping("feign/dept/find/{id}")
    public Dept findid(@PathVariable Long id) {
        System.out.println("find " + id);
        return deptService.findByid(id);
    }
}
