// POJO class to represent all error outputs.s

package com.randomchaffee.student_api.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
	// class fields
	private int status;
	private List<String> messages;
	private LocalDateTime timestamp = LocalDateTime.now();
	
	// constructor
	public ApiError(int status, List<String> messages) {
		this.status = status;
		this.messages = messages;
	}
	
	// getters
	public int getStatus() { return status; }
	public List<String> getMessage() { return messages; }
	public LocalDateTime getTimestamp() { return timestamp; }
}
