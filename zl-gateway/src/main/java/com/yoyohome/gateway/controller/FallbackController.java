package com.yoyohome.gateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.zl.common.util.Response;

import reactor.core.publisher.Mono;

/**
 *
 * @author nolimits
 * @since 2019-08-27
 */

@RestController
public class FallbackController {
	
//	@GetMapping("/fallback")
//	public Mono<Map<String, Object>> fallback(ServerWebExchange exchange, Throwable throwable) {
//		
//		System.out.println("进入fallback");
//		ServerHttpRequest request = exchange.getRequest();
//		
//		System.out.println(throwable.getMessage());
//		
//		Map<String, Object> r = new HashMap<>();
//		r.put("code", 500);
//		r.put("msg", "服务不可用");
//		
//		return Mono.just(r);
//	}
	
	@GetMapping("/fallback")
	public Mono<Response<Void>> fallback(ServerWebExchange exchange, Throwable throwable) {
//		AbstractErrorWebExceptionHandler handler;
		
		System.out.println("进入fallback");
		ServerHttpRequest request = exchange.getRequest();
		
		System.out.println(throwable.toString());
		
		return Mono.just(Response.error("服务不可用"));
	}

}
