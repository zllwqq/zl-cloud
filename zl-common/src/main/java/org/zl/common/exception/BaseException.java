package org.zl.common.exception;

/**
 * 
 * @author nolimits
 * @since 2019-08-01
 */
public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 6723402853670755844L;

	private int code = 500;
	
	public int getCode() {
		return code;
	}

	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(int code, String message) {
		super(message);
		this.code = code;
	}
}
