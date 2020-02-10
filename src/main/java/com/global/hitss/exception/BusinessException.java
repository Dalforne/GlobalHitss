package com.global.hitss.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String [] params;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String errorCode, String... params) {
		super(errorCode);
		this.params = params;
	}
	
	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	public BusinessException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}
	
	public String[] getParams() {
		return params;
	}

}
