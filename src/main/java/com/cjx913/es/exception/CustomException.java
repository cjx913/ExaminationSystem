package com.cjx913.es.exception;

public class CustomException extends RuntimeException {
	//异常信息
	private String message;

	public CustomException() {
	}

	public CustomException(String message) {

		super(message);
		this.message = message;
	}

	public CustomException(String message, Throwable cause) {

		super(message, cause);
		this.message = message;
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
