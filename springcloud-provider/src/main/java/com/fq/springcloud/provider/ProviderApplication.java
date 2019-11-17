package com.fq.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qianfang, at 2019-11-13, 22:07
 **/
@SpringBootApplication

/**
 * 开启eureka客户端支持
 */
@EnableDiscoveryClient

/**
 * 开启对Hystrix熔断机制
 */
@EnableCircuitBreaker
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
