package com.atdev.student_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atdev.student_project.dto.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
