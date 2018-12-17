package com.yoyohome.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZlOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlOrderApplication.class, args);
    }
}
