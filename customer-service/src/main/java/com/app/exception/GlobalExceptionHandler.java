package com.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<Map<String, String>> hanldeApplicationException(ApplicationException e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", e.getMessage());
		return new ResponseEntity<>(errorResponse, e.getHttpStatus());
	}

}
