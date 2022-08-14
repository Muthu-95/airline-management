package com.app.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	USER_DETAILS_NOTFOUND("User details not found", HttpStatus.NOT_FOUND),
	INVALID_USER_ID("Invalid user id", HttpStatus.NOT_FOUND),
	INVALID_ROLE_ID("Please select valid role", HttpStatus.NOT_FOUND),
	INVALID_FIRST_NAME("Please enter valid first name", HttpStatus.NOT_FOUND),
	INVALID_LAST_NAME("Please enter valid last name", HttpStatus.NOT_FOUND),
	INVALID_PASSWORD("Invalid password", HttpStatus.NOT_FOUND),
	INVALID_MOBILE_NUMBER("Invalid mobile number", HttpStatus.NOT_FOUND),
	USER_ALREADY_EXISTS("Account already exists for this email", HttpStatus.CONFLICT);

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
