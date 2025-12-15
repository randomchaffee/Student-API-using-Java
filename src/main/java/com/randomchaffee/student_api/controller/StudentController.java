package com.randomchaffee.student_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.randomchaffee.student_api.model.Student;
import com.randomchaffee.student_api.service.StudentService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // get ALL students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }
    
    // get student
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
    	return service.getStudentById(id);
    }
    
    // add a student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student s) {
        return service.addStudent(s);
    }
    
    // update a student
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
    	String updated = service.updateStudent(id, student);
    	return ResponseEntity.ok(updated);
    }
    
    // delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
    	service.deleteStudent(id);
    	return ResponseEntity.ok("Student deleted successfully.");
    }
}	