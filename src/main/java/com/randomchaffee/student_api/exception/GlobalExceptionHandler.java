// class to handle global exceptions

package com.randomchaffee.student_api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// Validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String errorMsg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		ApiError error = new ApiError(400, errorMsg);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	// Manual "student not found" errors
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFound(StudentNotFoundException ex) {
		ApiError error = new ApiError(404, ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
