package com.fq.springcloud.zuul.conf;

import com.fq.springcloud.zuul.filter.PreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qianfang, at 2019-11-18, 23:24
 **/
@Configuration
public class ZuulConf {

    /**
     * 配置zuul的过滤器
     *
     * @return
     */
    @Bean
    public PreFilter getPreFilter() {
        return new PreFilter();
    }
}
