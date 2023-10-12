package com.example.msspecification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@FieldNameConstants
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     Long id;

     String firstName;

     String lastName;

     int age;

     double gpa;

     String studentNumber;


}
