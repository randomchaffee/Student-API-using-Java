package com.randomchaffee.student_api.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(Long id) {
		super("Student with id " + id + " not found.");
	}
}
