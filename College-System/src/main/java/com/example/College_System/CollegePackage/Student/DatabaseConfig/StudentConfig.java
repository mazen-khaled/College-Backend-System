package com.example.College_System.CollegePackage.Student.DatabaseConfig;

import com.example.College_System.CollegePackage.Student.DataBaseLayer.Student;

import com.example.College_System.CollegePackage.Student.ReposatoryLayer.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mazen = new Student("Mazen", "kmazen275@gmail.com", LocalDate.of(2001, 3, 14), 3.01F);
            studentRepository.save(mazen);
        };
    }
}
