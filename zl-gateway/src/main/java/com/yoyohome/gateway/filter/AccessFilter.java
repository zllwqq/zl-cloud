package com.yoyohome.gateway.filter;

import java.nio.charset.StandardCharsets;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author nolimits
 * @since 2019-08-25
 */
@Slf4j
@Component
public class AccessFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
        // -1 is response write filter, must be called before that
		return -100;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		log.info("请求uri:" + request.getURI());
		log.info("请求path:" + request.getPath());
		
		// TODO 白名单过滤
		if ("/car/v2/api-docs".equals(request.getPath().toString()) || "/user/v2/api-docs".equals(request.getPath().toString())) {
			
		} else {
//			String token = request.getQueryParams().getFirst("token");
			String token = request.getHeaders().getFirst("token");
			
			if (token == null || token.isEmpty()) {
				log.info("token is empty...");
				ServerHttpResponse response = exchange.getResponse();
				
//				//303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
//				String url = "http://www.baidu.com";
//	            response.setStatusCode(HttpStatus.SEE_OTHER);
//	            response.getHeaders().set(HttpHeaders.LOCATION, url);
//				return response.setComplete();
				
//				JSONObject message = new JSONObject();
//	            message.put("code", -1);
//	            message.put("msg", "鉴权失败");
//	            byte[] bytes = message.toJSONString().getBytes(StandardCharsets.UTF_8);
//	            DataBuffer buffer = response.bufferFactory().wrap(bytes);
//	            //指定编码，否则在浏览器中会中文乱码
////	            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
//	            response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
//				response.setStatusCode(HttpStatus.UNAUTHORIZED);
//				return response.writeWith(Mono.just(buffer));
			}
		}
		

		return chain.filter(exchange);
	}

}
