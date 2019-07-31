package com.yoyohome.order.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({Exception.class})
	public Map<String, Object> errorHandler(Exception e) {
		log.error("系统异常", e);
		
		Map<String, Object> r = new HashMap<>();
		r.put("code", -1);
		r.put("message", "order系统异常");
		
		return r;
	}
}
