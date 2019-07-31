package com.yoyohome.zuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.util.ReflectionUtils;

import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZuulSendErrorFilter extends SendErrorFilter {

	@Override
    public Object run() {
		log.info("自定义SendErrorFilter");
        // 重写 run方法        
        try{
            RequestContext ctx = RequestContext.getCurrentContext();
            // 直接复用异常处理类
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            log.info("异常信息:{}", exception.getThrowable());
            // 这里可对不同异常返回不同的错误码
            HttpServletResponse response = ctx.getResponse();
            response.getOutputStream().write(("{\"code\":\"-1\",\"msg\":\"" + exception.getErrorCause() + "\"}").getBytes());
                 
        }catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
