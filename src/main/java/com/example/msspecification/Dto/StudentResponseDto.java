package com.example.msspecification.Dto;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String studentNumber;
}
