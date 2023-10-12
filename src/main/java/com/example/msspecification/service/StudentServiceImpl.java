package com.example.msspecification.service;


import com.example.msspecification.entity.SearchCriteria;
import com.example.msspecification.entity.Student;
import com.example.msspecification.entity.StudentSpecification;
import com.example.msspecification.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public List<Student> getAllBy(){
        return studentRepository.findAll(ageGreaterThan(20));
    }
    public List<Student> getAllByName(){
        return studentRepository.findAll(Specification.where(nameLike("Bayram")).and(ageGreaterThan(20)));
    }
    public List<Student> gpaGreaterThan91(){
        return studentRepository.findAll(gpaGreaterThan(91.0));
    }

    public List<Student> getAllByCriteria(List<SearchCriteria> dto){
        StudentSpecification studentSpecification=new StudentSpecification();
        dto.forEach(searchCriteria -> studentSpecification.and((Specification<Student>) searchCriteria));
        return studentRepository.findAll(studentSpecification);

    }

    private Specification<Student> ageGreaterThan(int age) {
        return ((root,query,criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.age),age));
    }
    private Specification<Student> nameLike(String firstName){
        return ((root,query,criteriaBuilder) -> criteriaBuilder.like(root.get(Student.Fields.firstName),firstName));

    }
    private Specification<Student> gpaGreaterThan(double gpa){
        return ((root,query,criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.gpa),gpa));
    }
}


