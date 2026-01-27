package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }
    public StudentModel updateStudent(String id, StudentModel student){
        StudentModel existingStudent = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);

    }
    public void deleteStudent(String id){
        StudentModel student= repository.findById(id).orElseThrow(()-> new RuntimeException("no student found"));
        repository.delete(student);
    }
}
