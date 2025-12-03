package com.example.student_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    	return repo.findById(id).orElse(null);
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
    public String deleteStudent(Long id) {
    	if (!repo.existsById(id)) {
    		return "Student not found.";
    	}
    	
    	repo.deleteById(id);
    	return "Student deleted successfully.";
    }
    
}