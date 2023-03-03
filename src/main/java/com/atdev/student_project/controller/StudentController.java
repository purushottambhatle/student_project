package com.atdev.student_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.student_project.dto.Student;
import com.atdev.student_project.service.StudentServices;
import com.atdev.student_project.util.ResponseStructure;


@RestController
public class StudentController {
	@Autowired
	private StudentServices services;
	
	@PostMapping("/savestudent")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return services.saveStudent(student);
	}
	
	@DeleteMapping("/{studentid}")
	public ResponseEntity<ResponseStructure<Student>>  deleteStudent(@PathVariable long studentid) {
		return services.deletestudent(studentid);
	}
	
	@GetMapping("/{studentid}")
	public  ResponseEntity<ResponseStructure<Student>>  getStudentById(@PathVariable long studentid){
		return services.getStudentById(studentid);
		 
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<ResponseStructure<Student>>  updateStudent(@RequestBody Student student){
		return services.updateStudent(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		return services.getAllList();
	}
		
}
