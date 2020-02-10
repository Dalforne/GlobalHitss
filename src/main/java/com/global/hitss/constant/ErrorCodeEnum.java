package com.global.hitss.constant;

public enum ErrorCodeEnum {

	// Exception Erros

	INVALID_ENTRY_HEIGHT("E001","Invalid Height", ""),
	INVALID_NUMBER_POSTERS("E002","Invalid number of Posters", ""),
	INVALID_WALL_POINTS("E003","Invalid number of wall points", ""),
	INVALID_LENGTH("E004","Invalid number of wall points", ""),
	NOT_MAPPED("", "Erro não mapeado", "");

	ErrorCodeEnum(String errorCode, String errorMsg, String exceptionClass) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.exceptionClass = exceptionClass;
	}

	private String errorCode;
	private String errorMsg;
	private String exceptionClass;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public static ErrorCodeEnum getByExceptionClass(String exceptionClass) {
		for (ErrorCodeEnum en : ErrorCodeEnum.values()) {
			if (en.getExceptionClass().equalsIgnoreCase(exceptionClass)) {

				return en;
			}
		}

		ErrorCodeEnum.NOT_MAPPED.setErrorCode(exceptionClass);
		return ErrorCodeEnum.NOT_MAPPED;

	}

	public static ErrorCodeEnum getByErrorCode(String errorCode) {
		for (ErrorCodeEnum en : ErrorCodeEnum.values()) {
			if (en.getErrorCode().equalsIgnoreCase(errorCode)) {

				return en;
			}
		}

		ErrorCodeEnum.NOT_MAPPED.setErrorCode(errorCode);
		return ErrorCodeEnum.NOT_MAPPED;
	}

}
