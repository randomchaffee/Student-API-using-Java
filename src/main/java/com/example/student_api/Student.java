package com.example.student_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Name is required")
    private String name;
	
	@NotNull(message = "Age is required")
	@Min(value = 0, message = "Age must be at least 0")
    private Integer age;
	
	@NotBlank(message = "Course is required")
    private String course;
    
    public Student() {}
    
    public Student(String name, Integer age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
    
    // getters and setters
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public  String getCourse() { return course; }
    public Long getId() { return id; }
    
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setId(Long id) { this.id = id; }
    
}