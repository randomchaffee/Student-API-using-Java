// POJO class to represent all error outputs.s

package com.randomchaffee.student_api.exception;

import java.time.LocalDateTime;

public class ApiError {
	// class fields
	private int status;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	
	// constructor
	public ApiError(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	// getters
	public int getStatus() { return status; }
	public String getMessage() { return message; }
	public LocalDateTime getTimestamp() { return timestamp; }
}
