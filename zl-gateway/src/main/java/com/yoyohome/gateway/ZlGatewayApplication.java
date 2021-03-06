package com.yoyohome.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZlGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZlGatewayApplication.class, args);
	}

}
