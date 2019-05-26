package nl.thuis.tutorial.rest.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nl.thuis.tutorial.rest.entity.ErrorResponse;
import nl.thuis.tutorial.rest.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
