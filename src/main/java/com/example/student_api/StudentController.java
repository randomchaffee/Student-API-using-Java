package com.example.student_api;

import org.springframework.web.bind.annotation.*;
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
    public Student getStudent(@PathVariable int id) {
    	return service.getStudentById(id);
    }
    
    // add a student
    @PostMapping
    public String addStudent(@RequestBody Student s) {
        service.addStudent(s);
        return "Student added!";
    }
    
    // update a student
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
    	return service.updateStudent(id, student);
    }
    
    // delete a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
    	return service.deleteStudent(id);
    }
}	