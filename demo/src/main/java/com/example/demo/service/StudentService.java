package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }
    //Create

    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

}
