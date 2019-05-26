package nl.thuis.tutorial.rest.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nl.thuis.tutorial.rest.entity.ErrorResponse;

@ControllerAdvice
public class GlobalRestExceptionHandler {

	// Adding exception handler to catch any exceptions
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleAllException(Exception e){
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
