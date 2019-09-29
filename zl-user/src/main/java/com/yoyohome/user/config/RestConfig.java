package com.yoyohome.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author nolimits
 * @since 2019-08-27
 */
@Configuration
public class RestConfig {

	@LoadBalanced
	@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory okHttp3ClientHttpRequestFactory) {
        return new RestTemplate(okHttp3ClientHttpRequestFactory);
    }

	/**
	 * SimpleClientHttpRequestFactory 底层实现-jdk的 HttpConnection
	 * HttpComponentsClientHttpRequestFactory 底层实现-Apache HttpClient
	 * OkHttp3ClientHttpRequestFactory 底层实现-OkHttp
	 * @return
	 */
    @Bean
    public ClientHttpRequestFactory okHttp3ClientHttpRequestFactory() {
    	OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        // 读取时间，单位为ms
        factory.setReadTimeout(5000);
        // 连接时间，单位为ms
        factory.setConnectTimeout(2000);
        return factory;
    }
}
