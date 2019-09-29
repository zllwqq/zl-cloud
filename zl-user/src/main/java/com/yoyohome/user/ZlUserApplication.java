package com.yoyohome.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "com.yoyohome" })
public class ZlUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZlUserApplication.class, args);
	}

}
