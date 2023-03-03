package com.atdev.student_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.atdev.student_project.dao.StudentDao;
import com.atdev.student_project.dto.Student;
import com.atdev.student_project.exception.IdNotFoundException;
import com.atdev.student_project.util.ResponseStructure;

@Service
public class StudentServices {

	@Autowired
	private StudentDao dao;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student student2 = dao.saveStudent(student);

		structure.setMessage("student saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(student2);

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> deletestudent(long studentid) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		dao.deleteStudent(studentid);
		structure.setMessage("student deleted sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {

		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student student2 = dao.updateStudent(student);
		if (student2 != null) {
			structure.setMessage("sucessfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student2);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Student>> getStudentById(long studentid) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student student2 = dao.getStudentById(studentid);
		if (student2 != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student2);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public List<Student> getAllList() {
		return dao.findAllList();
	}

}
