package com.example.College_System.CollegePackage.Student.ControllerLayer;

import com.example.College_System.CollegePackage.Student.DataBaseLayer.Student;
import com.example.College_System.CollegePackage.Student.ServiceLayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/students")
public class StudentControl {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @PostMapping
    public void postNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudentData(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}
