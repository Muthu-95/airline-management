package com.app.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpStatus httpStatus;
	private final ErrorDetails errorDetails;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public BusinessException(HttpStatus httpStatus, String errorCode, String errorMessage) {
		super(errorMessage);
		this.httpStatus = httpStatus;
		this.errorDetails = new ErrorDetails(errorCode, errorMessage);
	}

}
