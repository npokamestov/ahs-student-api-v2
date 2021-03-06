package com.adhocsensei.ahsstudentapi.controller;

import com.adhocsensei.ahsstudentapi.dao.StudentRepository;
import com.adhocsensei.ahsstudentapi.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/studentCourse")
    public List<Student> getAllStudentCourses(@RequestParam(required = false) Long userId,
                                              @RequestParam(required = false) Long courseId) {
        if (userId !=null && courseId !=null) {
            return repo.findByUserIdAndCourseId(userId,courseId);
        } else
        return repo.findAll();
    }

    @GetMapping("/studentCourse/studentList/{userId}")
    public List<Student> getAllStudentCoursesByStudentId(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping("/studentCourse/senseisRegisteredCourses/{courseId}")
    public List<Student> getAllStudentCoursesByCourseId(@PathVariable Long courseId) {
        return repo.findByCourseId(courseId);
    }

    @GetMapping("/studentCourse/{id}")
    public Optional<Student> getStudentCourseById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping("/studentCourse")
    public Student createStudentCourse(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/studentCourse/{id}")
    public void updateStudentCourseById(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            student.setId(id);
            repo.save(student);
        }
//        catch error and have appropriate response
    }

    @DeleteMapping("/studentCourse/{id}")
    public void deleteStudentCourseById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
