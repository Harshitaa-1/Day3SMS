package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Create function API
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){

        return service.addStudent(student);
    }
    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id,@RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "student deleted";
    }

}
