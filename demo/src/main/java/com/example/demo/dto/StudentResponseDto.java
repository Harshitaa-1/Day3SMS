package com.example.demo.dto;

import jakarta.validation.constraints.Email;


public record StudentResponseDto(

    String id,
    String name,
    int Age,
    String Email){}

