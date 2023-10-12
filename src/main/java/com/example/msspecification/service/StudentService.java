package com.example.msspecification.service;

import com.example.msspecification.entity.SearchCriteria;
import com.example.msspecification.entity.Student;

import java.util.List;

public interface StudentService {


    List<Student> getAllByCriteria(List<SearchCriteria> dto);
}
