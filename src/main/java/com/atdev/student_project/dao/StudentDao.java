package com.atdev.student_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atdev.student_project.dto.Student;
import com.atdev.student_project.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public void deleteStudent(long studentid) {
	  repo.deleteById(studentid);
		
	}

	public Student getStudentById(long studentid) {
		if (repo.findById(studentid).isPresent()) {
			return repo.findById(studentid).get();
		} else {
			return null;
		}
	}

	public Student updateStudent(Student student) {
		if (student != null) {
			 Student student2 = repo.save(student);
			 return student2;
		}
		return null; 
	}
	
	public List<Student> findAllList(){
		return repo.findAll();
	}
}
