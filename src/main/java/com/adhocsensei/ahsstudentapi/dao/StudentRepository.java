package com.adhocsensei.ahsstudentapi.dao;

import com.adhocsensei.ahsstudentapi.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUserId(Long userId);
    List<Student> findByCourseId(Long courseId);
    List<Student> findByUserIdAndCourseId(Long userId, Long courseId);
}
