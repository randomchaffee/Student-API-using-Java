package com.example.student_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    private Integer age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
    
    // getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public  String getCourse() { return course; }
    
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    
}