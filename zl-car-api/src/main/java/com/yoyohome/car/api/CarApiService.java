package com.yoyohome.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.zl.common.exception.BaseException;
import org.zl.common.util.Response;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yoyohome.car.dto.CarDTO;

/**
 *
 * @author nolimits
 * @since 2019-08-26
 */
@Component
public class CarApiService {

	private final static String PREFIX = "http://zl-car/";
	
	@LoadBalanced
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "errorFallback")
	public CarDTO getById(Long id) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
		Response<CarDTO> r = restTemplate.exchange(PREFIX + "car/"+id, HttpMethod.GET, new HttpEntity<>(headers),
				new ParameterizedTypeReference<Response<CarDTO>>() {}).getBody();
		
		return r.getResponseData();
	}
	
	public CarDTO errorFallback(Long id) {
		System.out.println("进入carApi的fallback");
		throw new BaseException(503, "服务异常不可用，触发hystrix降级");
	}
}
