package nl.thuis.tutorial.rest.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nl.thuis.tutorial.rest.entity.StudentErrorResponse;
import nl.thuis.tutorial.rest.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// Adding exception handler for StudentNotFoundException
	// ExceptionHandlers in the controller class only catch exception for that controller (Local Catch Exceptions)
	// In the controller-advice it will catch exception for all controllers. (GLOBAL catch Exceptions)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Adding exception handler to catch any exceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleAllException(Exception e){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
