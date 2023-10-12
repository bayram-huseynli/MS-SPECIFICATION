package com.example.msspecification;

import com.example.msspecification.entity.Student;
import com.example.msspecification.repository.StudentRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MsspecificationApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsspecificationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student a1=Student.builder()
                .id(3L)
                .firstName("Bayram1")
                .lastName("Huseynli")
                .age(19)
                .studentNumber("AA1812414")
                .build();
        studentRepository.save(a1);
    }
}
