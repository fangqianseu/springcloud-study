package com.fq.springcloud.consumer;

import com.fq.springcloud.myrules.MyNewRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qianfang, at 2019-11-14, 09:37
 **/
@SpringBootApplication
/**
 * eureka客户端配置
 */
@EnableEurekaClient

/**
 * 自定义的ribbon负载均衡规则
 *
 * configuration = MyNewRule.class：自定义的Ribbon负载均衡规则
 *                  不能放在@ComponentScan所扫描的当前包以及子包下，否则会被所有的Ribbon客户端共享
 *                  即在同级的另一个目录下
 * */
//@RibbonClient(name = "springcloud-provider")  使用自带的lb算法
@RibbonClient(name = "springcloud-provider", configuration = MyNewRule.class)

/**
 * feign依赖配置
 * 自动集成 ribbon配置
 */
@EnableFeignClients(basePackages = "com.fq.springcloud")
@ComponentScan("com.fq.springcloud")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
