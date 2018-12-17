package com.yoyohome.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@EnableZuulServer
@EnableEurekaClient
@SpringBootApplication
public class ZlZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlZuulApplication.class, args);
    }

}

