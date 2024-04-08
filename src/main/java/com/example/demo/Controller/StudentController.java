package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents(){
       return service.getAllStudents();
    }

    @GetMapping("students/{rollNo}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> getStudentsById(@PathVariable int rollNo){
        return service.getStudentsByRollNo(rollNo);
    }

    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
       service.addStudent(student);
    }

    @PutMapping("student/{rollNo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student updateStudent(@RequestBody Student student, @PathVariable int rollNo){
      return   service.update(student,rollNo);
    }

    @DeleteMapping("student/{rollNo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int rollNo){
        service.deleteStudent(rollNo);
    }
}
