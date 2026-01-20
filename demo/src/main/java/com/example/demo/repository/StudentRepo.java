package com.example.demo.repository;

import com.example.demo.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository <StudentModel, String> {

}
