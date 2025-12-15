package com.randomchaffee.student_api.exception;

public class StudentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(Long id) {
		super("Student with id " + id + " not found.");
	}
}
