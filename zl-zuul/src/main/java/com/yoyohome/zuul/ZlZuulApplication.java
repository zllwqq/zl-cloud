package com.yoyohome.zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.yoyohome.zuul.filter.ZuulSendErrorFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZlZuulApplication {

	@Value("${zuul.SendErrorFilter.error.disable}")
	private boolean sendErrorFilterDisable;
	
    public static void main(String[] args) {
        SpringApplication.run(ZlZuulApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(name="zuul.SendErrorFilter.error.disable")
    public ZuulSendErrorFilter zuulSendErrorFilter() {
    	System.out.println("禁用" + sendErrorFilterDisable);
        return new ZuulSendErrorFilter();
    }
}

