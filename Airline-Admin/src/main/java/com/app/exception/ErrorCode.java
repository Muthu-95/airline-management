package com.app.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	AIRLINE_DETAILS_NOTFOUND("Airline details not found", HttpStatus.NOT_FOUND);

	private final String message;
	private final HttpStatus httpStatus;

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	ErrorCode(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

}
