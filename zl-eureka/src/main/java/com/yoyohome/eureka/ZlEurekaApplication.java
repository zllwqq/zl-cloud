package com.yoyohome.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZlEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlEurekaApplication.class, args);
    }
}
