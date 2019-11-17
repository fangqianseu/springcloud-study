package com.fq.springcloud.consumer.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author qianfang, at 2019-11-14, 08:53
 **/
//@Configuration
public class ConsumerConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 选择提供的负载均衡算法 IRule的实现类
    // @Bean
    // public IRule myIRule() {
    //   return new RandomRule();
    //}

}
