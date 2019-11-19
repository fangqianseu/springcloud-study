package com.fq.springcloud.service;

import com.fq.springcloud.entities.Dept;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * fallbackFactory：集成Hystrix服务降级，
 * 在客户端模块模块yml： feign.hystrix.enabled=true 开启服务降级
 * 该注解被消费端扫描使用
 *
 * 耦合太大 考虑在消费端重写
 */
//@FeignClient(value = "springcloud-provider", fallbackFactory = DeptServiceFallBack.class)
public interface DeptService {

    //    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    boolean addDept(Dept dept);

    //    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    List<Dept> findAll();

    /**
     * 路径参数必须写全 @PathVariable 否则报错
     *
     * @param id
     * @return
     */
//    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    Dept findByid(@PathVariable("id") Long id);
}

