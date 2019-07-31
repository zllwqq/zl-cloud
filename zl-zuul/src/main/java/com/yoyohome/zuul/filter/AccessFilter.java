package com.yoyohome.zuul.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        String token = request.getHeader("token");
        if (token == null) {
        	HttpServletResponse response = ctx.getResponse();
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            ctx.setSendZuulResponse(false); //终止转发，返回响应报文
            ctx.setResponseStatusCode(400);
            Map<String,String> responseMap = new HashMap<>();
            responseMap.put("code", "-1");
            responseMap.put("msg", "缺少token");
            ctx.setResponseBody(JSON.toJSONString(responseMap));
        } else {
//        	throw new ZuulRuntimeException(new ZuulException("测试过滤器异常", HttpStatus.OK.value(), "测试过滤器异常"));
        }
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return -1;
	}

}
