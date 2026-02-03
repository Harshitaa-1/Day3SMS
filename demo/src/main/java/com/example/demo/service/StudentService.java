package com.example.demo.service;

import com.example.demo.dto.StudentRequestDto;
import com.example.demo.dto.StudentResponseDto;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import lombok.Data;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.util.Arrays.stream;

@Service

public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }
    //Create

    /*
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    */

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );


    }

    public List<StudentResponseDto> getAllStudents(){

        List<StudentModel> students=repository.findAll();
        return students.stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getEmail()
                ))
                .toList() ;
    }
    public StudentModel updateStudent(String id, StudentModel student) {

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
