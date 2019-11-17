package com.fq.springcloud.service;

import com.fq.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 */

@Component
public class DeptServiceFallBack implements FallbackFactory<DeptService> {

    //统一对我们的接口DeptClientService处理熔断
    @Override
    public DeptService create(Throwable throwable) {

        return new DeptService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public List findAll() {
                return null;
            }

            @Override
            public Dept findByid(Long id) {
                return new Dept().setDeptNo(id)
                        .setDeptName("ID " + id + " 没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
            }
        };
    }
}