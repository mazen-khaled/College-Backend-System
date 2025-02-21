package com.example.College_System.CollegePackage.Student.DatabaseConfig;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.College_System.CollegePackage.Student.DataBaseLayer.Student;
import com.example.College_System.CollegePackage.Student.ReposatoryLayer.StudentRepository;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mazen = new Student("Mazen", "kmazen275@gmail.com", "1234", LocalDate.of(2001, 3, 14), 3.01F);
            studentRepository.save(mazen);
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:63342") // Allow requests from this origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials (e.g., cookies)
            }
        };
    }
}