package com.yoyohome.zuul.filter;


import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author nolimits
 *
 */
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Throwable throwable = super.getError(webRequest);
        Map<String, Object> result = new HashMap<>();
        if (throwable != null) {
            throwable = throwable.getCause();
            String msg = "系统异常";
            if (throwable instanceof IOException) {
                msg = "文件操作模块失败，请稍后重试";
            }
            result.put("msg", msg);
            result.put("data", Collections.EMPTY_MAP);
            result.put("code", -1);
        } else {
            result.put("timestamp", System.currentTimeMillis());
            result.put("error", "404");
            result.put("status", "404");
            result.put("message", "404 not found");
            
        }
        return result;
    }
}
