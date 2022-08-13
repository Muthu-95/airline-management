package com.app.exception;

public class ApplicationException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage());
	}

}
