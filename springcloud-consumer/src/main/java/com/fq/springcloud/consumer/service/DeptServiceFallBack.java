package com.fq.springcloud.consumer.service;

import com.fq.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 */

@Component
public class DeptServiceFallBack implements FallbackFactory<FeignDeptService> {
    public static final Logger LOGGER = LoggerFactory.getLogger(DeptServiceFallBack.class);

    //统一对我们的接口DeptClientService处理熔断
    @Override
    public FeignDeptService create(Throwable throwable) {

        return new FeignDeptService() {
            @Override
            public boolean addDept(Dept dept) {
                LOGGER.error(dept + " error, hystrix deal");
                return false;
            }

            @Override
            public List findAll() {
                LOGGER.error("findAll error, hystrix deal");
                return null;
            }

            @Override
            public Dept findByid(Long id) {
                LOGGER.error("id: " + id + " error, findByid hystrix deal");
                return new Dept().setDeptNo(id)
                        .setDeptName("ID " + id + " 没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
            }
        };
    }
}