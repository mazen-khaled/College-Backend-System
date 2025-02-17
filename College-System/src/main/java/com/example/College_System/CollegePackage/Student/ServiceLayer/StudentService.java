package com.example.College_System.CollegePackage.Student.ServiceLayer;

import com.example.College_System.CollegePackage.Student.DataBaseLayer.Student;
import com.example.College_System.CollegePackage.Student.ReposatoryLayer.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Get All Student Table
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Get A Student By ID Number
    public Optional<Student> getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NoSuchElementException("Don't Found Student with id: " + id);
        }
        return student;
    }

    // Add New Student to Table
    public void addStudent(Student student){
        Optional<Student> existingStudent = studentRepository.findByEmail(student.getStudentEmail());
        if (existingStudent.isPresent()) {
            throw new IllegalArgumentException("This Email is Registered Before: " + student.getStudentEmail());
        }
        studentRepository.save(student);
    }

    // Delete a Student Based on his ID
    public void deleteStudentById(Long id){
        Optional<Student> existingID = studentRepository.findById(id);
        if (existingID.isEmpty()) {
            throw new NoSuchElementException("Don't Found Student with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Update a Student Data Based On His ID
    @Transactional
    public void updateStudentData(Student studentUpdated){
        Optional<Student> existingID = studentRepository.findById(studentUpdated.getStudentId());
        if (existingID.isEmpty()) {
            throw new NoSuchElementException("Don't Found Student with id: " + studentUpdated.getStudentId());
        }

        if (studentUpdated.getStudentEmail() != null) {
            studentUpdated.setStudentEmail(studentUpdated.getStudentEmail());
        }
        if (studentUpdated.getStudentName() != null) {
            studentUpdated.setStudentName(studentUpdated.getStudentName());
        }
        if (studentUpdated.getStudentDOB() != null) {
            studentUpdated.setStudentDOB(studentUpdated.getStudentDOB());
        }
        if (studentUpdated.getStudentGPA() != null) {
            studentUpdated.setStudentGPA(studentUpdated.getStudentGPA());
        }
        studentRepository.save(studentUpdated);
    }
}
