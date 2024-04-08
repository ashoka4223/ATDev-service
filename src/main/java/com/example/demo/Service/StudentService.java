package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return  repo.findAll();
    }

    public void addStudent(Student student) {
        repo.save(student);
    }

    public Student update(Student student,int rollNo) {
        student.setRollNo(rollNo);
        student.setName(student.getName());
        student.setCollageName(student.getCollageName());
        student.setLevel(student.getLevel());
        return  repo.save(student);

    }

    public void deleteStudent(int rollNo) {
         repo.deleteById(rollNo);
    }

    public Optional<Student> getStudentsByRollNo(int rollNo) {
        return repo.findById(rollNo);
    }
}
