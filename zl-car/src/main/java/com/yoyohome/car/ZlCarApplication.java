package com.yoyohome.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZlCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlCarApplication.class, args);
        
    }

}

