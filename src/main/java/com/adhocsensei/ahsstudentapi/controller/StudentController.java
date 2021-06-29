package com.adhocsensei.ahsstudentapi.controller;

import com.adhocsensei.ahsstudentapi.dao.StudentRepository;
import com.adhocsensei.ahsstudentapi.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/studentCourse")
    public List<Student> getAllStudentCourses() {
        return repo.findAll();
    }

    @GetMapping("/studentCourse/{id}")
    public Student getAStudentCourse(@PathVariable Long id) {
        return repo.getById(id);
    }

    @PostMapping("/studentCourse")
    public Student createAStudentCourse(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/studentCourse/{id}")
    public void updateAStudentCourse(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        repo.save(student);
    }

    @DeleteMapping("/studentCourse/{id}")
    public void deleteAStudentCourse(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
