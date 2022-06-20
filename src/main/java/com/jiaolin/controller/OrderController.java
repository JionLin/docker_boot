package com.jiaolin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author johnny
 * @Classname OrderController
 * @Description
 * @Date 2022/3/19 4:22 下午
 */
@RestController
public class OrderController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping("/order/docker")
    public String helloDocker() {
        return "hello docker" + "\t" + port + "\t" + UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/order/index", method = RequestMethod.GET)
    public String index() {
        return "服务端口号: " + "\t" + port + "\t" + UUID.randomUUID().toString();
    }
}
