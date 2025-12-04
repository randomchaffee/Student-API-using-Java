package com.randomchaffee.student_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomchaffee.student_api.exception.StudentNotFoundException;
import com.randomchaffee.student_api.model.Student;
import com.randomchaffee.student_api.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
	// replace students ArrayList with repository
	@Autowired
	StudentRepository repo;

    public List<Student> getAll() {
        return repo.findAll();
    }

    // Methods
    
    // find a student in the list using its id
    public Student getStudentById(Long id) {
    	return repo.findById(id)
    			.orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }
    
    // add a student to data list
    public Student addStudent(Student s) {
        return repo.save(s);
    }
    
    // update student values
    public Student updateStudent(Long id, Student updatedStudent) {
    	Student existing = repo.findById(id)
    			.orElseThrow(() -> new RuntimeException("Student not found"));

    	existing.setName(updatedStudent.getName());
    	existing.setAge(updatedStudent.getAge());
    	existing.setCourse(updatedStudent.getCourse());
    	
    	return repo.save(existing);
    }
    
    // delete a student
    public void deleteStudent(Long id) {
    	if (!repo.existsById(id)) {
    		throw new RuntimeException("Student not found");
    	}
    	
    	repo.deleteById(id);
    }
    
}