package com.atdev.student_project.exception;

public class IdNotFoundException extends RuntimeException{
	private String message="id not found";

	public String IdNotFoundException() {
		return "Id not Found";
	}

	@Override
	public String getMessage() {

		return super.getMessage();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();

	}

}
