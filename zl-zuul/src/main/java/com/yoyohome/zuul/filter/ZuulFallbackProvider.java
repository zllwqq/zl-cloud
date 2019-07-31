package com.yoyohome.zuul.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulFallbackProvider implements FallbackProvider {

	/**
	 * * 表示对所有路由使用
	 * service-id 对于某个服务实例使用
	 */
	public String getRoute() {
		return "*";
	}

	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		log.error(route, cause);
		
		
		return new ClientHttpResponse() {

			public InputStream getBody() throws IOException {
				Map<String, Object> result = new HashMap<>();
                result.put("message", route + "操作失败，系统繁忙请稍后重试！");
                result.put("data", Collections.EMPTY_MAP);
                result.put("businessCode", "-0000");
                result.put("code", -1);
                return new ByteArrayInputStream(JSONObject.toJSONBytes(result));
			}

			public HttpHeaders getHeaders() {
				HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
			}

			public HttpStatus getStatusCode() throws IOException {
				// 请求网关成功
				return HttpStatus.OK;
			}

			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			public void close() {
				
			}
			
		};
	}

}
