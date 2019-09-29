package org.zl.common.util;

import org.zl.common.enums.ResponseCodeEnum;
import org.zl.common.exception.BaseException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author nolimits
 * @since 2019-08-01
 */
@Data
public class Response<T> {

    /**
     * @see ResponseCodeEnum
     */
    private int code;

    private String msg;

    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> r = new Response<>();
        r.setCode(ResponseCodeEnum.OK.getCode());
        r.setData(data);
        r.setMsg("");

        return r;
    }

    public static <T> Response<T> success(T data,String msg){
        Response<T> r = new Response<>();
        r.setCode(ResponseCodeEnum.OK.getCode());
        r.setData(data);
        r.setMsg(msg);

        return r;
    }

    public static <T> Response<T> error(int code, String msg) {
        Response<T> r = new Response<>();
        r.setCode(code);
        r.setMsg(msg);

        return r;
    }

    public static <T> Response<T> error(String msg) {
        Response<T> r = new Response<>();
        r.setCode(ResponseCodeEnum.SERVER_ERROR.getCode());
        r.setMsg(msg);

        return r;
    }
    
    /**
     * 忽略自定义方法，否则json序列化时异常
     * @return
     */
    @JsonIgnore
    public T getResponseData() {
    	if (ResponseCodeEnum.OK.getCode() ==  this.code) {
    		return this.data;
    	} else {
    		throw new BaseException(this.msg);
    	}
    }
}
