package com.fq.springcloud.consumer.controller;

import com.fq.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author qianfang, at 2019-11-14, 08:59
 **/
//@RestController
public class RibbonConsumerController {
    private final static String PROVIDER_URL = "http://springcloud-provider";
    @Autowired
    private RestTemplate template;

    @RequestMapping("ribbon/dept/findAll")
    public List<Dept> findAll() {

        return template.getForObject(PROVIDER_URL + "/dept/findAll", List.class);
    }

}
