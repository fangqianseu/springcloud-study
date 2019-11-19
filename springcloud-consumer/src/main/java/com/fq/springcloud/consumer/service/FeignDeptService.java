package com.fq.springcloud.consumer.service;

import com.fq.springcloud.entities.Dept;
import com.fq.springcloud.service.DeptService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author qianfang, at 2019-11-18, 15:35
 **/

/**
 * 解耦 通过feign方式访问微服务
 * fallbackFactory=DeptServiceFallBack.class 整合hytrix熔断属性
 */
//@FeignClient(value = "springcloud-provider", fallbackFactory = DeptServiceFallBack.class)
@FeignClient(value = "springcloud-provider")
public interface FeignDeptService extends DeptService {
    @Override
    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    boolean addDept(Dept dept);

    @Override
    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    List<Dept> findAll();

    @Override
    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    Dept findByid(Long id);
}
