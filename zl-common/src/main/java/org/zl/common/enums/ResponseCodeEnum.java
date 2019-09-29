package org.zl.common.enums;

/**
 *
 * @author nolimits
 * @since 2019-08-16
 */
public enum ResponseCodeEnum {
	
	OK(200, "操作成功"),
	UNAUTHORIZED(401, "未登录认证"),
	FORBIDDEN(403, ""),
	NOT_FOUND(404, "未查询到数据"),
	SERVER_ERROR(500, "服务异常");
	
	private int code;
	
	private String msg;

	private ResponseCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
