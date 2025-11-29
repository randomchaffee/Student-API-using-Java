package com.example.student_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }
    
    
    
    
    
    
    // Methods
    
    // find a student in the list using its id
    public Student getStudentById(int id) {
    	return students.stream()
    			.filter(s -> s.getId() == id)
    			.findFirst()
    			.orElse(null);
    }
    
    // add a student to data list
    public void addStudent(Student s) {
        students.add(s);
    }
    
    // update student values
    public String updateStudent(int id, Student updatedStudent) {
    	Student existing = getStudentById(id);
    	if (existing == null) {
    		return "Student not found.";
    	}
    	
    	existing.setName(updatedStudent.getName());
    	existing.setAge(updatedStudent.getAge());
    	existing.setCourse(updatedStudent.getCourse());
    	
    	return "Student updated Succesfully.";
    }
    
    // delete a student
    public String deleteStudent(int id) {
    	Student existing = getStudentById(id);
    	if (existing == null) {
    		return "Student not found.";
    	}
    	
    	students.remove(existing);
    	return "Student deleted successfully.";
    }
    
}