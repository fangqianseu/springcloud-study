package com.fq.springcloud.provider.controller;

import com.fq.springcloud.entities.Dept;
import com.fq.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public boolean addDept() {

        Dept dept = new Dept();
        dept.setDeptName("hello");
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    /**
     * 出错后的熔断处理
     */
    @HystrixCommand(fallbackMethod = "fallback_findById")
    public Dept findById(@PathVariable long id) {
        Dept dept = deptService.findByid(id);
        if (dept == null) {
            throw new RuntimeException("该Id：" + id + "没有对应的信息");
        }
        return dept;
    }


    /**
     * 具体的熔断处理函数
     * 原理 aop ，耦合较高
     *
     * @return
     */
    public Dept fallback_findById(long id) {
        return new Dept().setDeptNo(id).setDeptName("ID " + id + " 没有对应的信息,null -- @HystrixCommand")
                .setDbSource("no this database in MySql");
    }


    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object deptDiscouery() {
        List<String> list = client.getServices();
        System.out.println("********** " + list);

        for (String microSrevice : list) {
            List<ServiceInstance> instances = client.getInstances(microSrevice);

            //打印服务信息
            for (ServiceInstance element : instances) {
                System.out.println(element.getServiceId());
                System.out.println(element.getHost());
                System.out.println(element.getPort());
                System.out.println(element.getUri());
            }
        }
        return this.client;
    }
}