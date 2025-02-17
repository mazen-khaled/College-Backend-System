package com.example.College_System.CollegePackage.Student.DataBaseLayer;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_SQ", sequenceName = "student_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_SQ")
    private Long studentId;

    private String studentName;
    private String studentEmail;
    private LocalDate studentDOB;
    private Float studentGPA;

    @Transient
    private Integer studentAge;

    public Student() {

    }

    public Student(String studentName, String studentEmail, LocalDate studentDOB, Float studentGPA) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDOB = studentDOB;
        this.studentGPA = studentGPA;
    }

    public Integer getStudentAge() {
        return Period.between(this.studentDOB, LocalDate.now()).getYears();
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Float getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(Float studentGPA) {
        this.studentGPA = studentGPA;
    }

    public LocalDate getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(LocalDate studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
