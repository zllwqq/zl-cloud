package com.yoyohome.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zl.common.exception.BaseException;
import org.zl.common.util.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nolimits
 * @since 2019-08-01
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public Response<Void> exceptionHandler(Exception e) {
        log.error("异常信息", e);
        if (e instanceof MethodArgumentNotValidException) {
            FieldError fieldError =
                    ((MethodArgumentNotValidException) e).getBindingResult().getFieldError();
            String errorMsg = fieldError != null ? fieldError.getDefaultMessage() : e.getMessage();
            return Response.error(errorMsg);
        } else if (e instanceof BaseException) {
            return Response.error(((BaseException) e).getCode(), e.getMessage());
        } else {
            return Response.error(e.toString());
//			//return Response.error("系统异常，请稍后再试");
        }
    }
    
//    @ExceptionHandler({Exception.class})
//    public Map<String, Object> exceptionHandler(Exception e) {
//        log.error("异常信息", e);
//        Map<String, Object> r = new HashMap<>();
//        
//        if (e instanceof MethodArgumentNotValidException) {
//            FieldError fieldError =
//                    ((MethodArgumentNotValidException) e).getBindingResult().getFieldError();
//            String errorMsg = fieldError != null ? fieldError.getDefaultMessage() : e.getMessage();
//            r.put("code", 500);
//            r.put("msg", errorMsg);
//        } else if (e instanceof BaseException) {
//        	r.put("code", ((BaseException) e).getCode());
//        	r.put("msg", e.getMessage());
//        } else {
//        	r.put("code", 500);
//            r.put("msg", e.getMessage());
//        }
//        return r;
//    }
}
