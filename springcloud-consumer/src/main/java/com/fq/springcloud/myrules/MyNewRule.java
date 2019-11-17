package com.fq.springcloud.myrules;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qianfang, at 2019-11-16, 22:17
 **/
@Configuration
public class MyNewRule {
    @Bean
    public IRule myRule() {
        return new MyRandomRule();
    }
}
