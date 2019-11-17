package com.fq.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author qianfang, at 2019-11-14, 09:59
 **/
@SpringBootApplication
/**
 * 启用eureka服务,接收其他服务注册
 */
@EnableEurekaServer
public class serverApplication {
    public static void main(String[] args) {
        SpringApplication.run(serverApplication.class, args);
    }
}
