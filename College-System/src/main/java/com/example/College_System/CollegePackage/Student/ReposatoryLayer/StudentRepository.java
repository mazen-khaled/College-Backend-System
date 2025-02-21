package com.example.College_System.CollegePackage.Student.ReposatoryLayer;

import com.example.College_System.CollegePackage.Student.DataBaseLayer.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    // Query for find data using email
    @Query("SELECT s FROM Student s WHERE s.studentEmail = ?1")
    Optional <Student> findByEmail (String email);
}
