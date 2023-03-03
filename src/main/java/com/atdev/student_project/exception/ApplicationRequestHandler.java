package com.atdev.student_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atdev.student_project.util.ResponseStructure;

@ControllerAdvice
public class ApplicationRequestHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("id not found for given id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
