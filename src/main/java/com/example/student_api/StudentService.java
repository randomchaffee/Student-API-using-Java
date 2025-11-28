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

    public void addStudent(Student s) {
        students.add(s);
    }
}