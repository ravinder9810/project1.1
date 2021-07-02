package com.demo.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.exception.InvalidEmailAndPassword;
import com.demo.exception.UserDoesNotExist;
import com.demo.exception.UserEmailAlreadyExistException;
import com.demo.exception.UserNameException;


@ControllerAdvice
public class ValidationMessages extends ResponseEntityExceptionHandler{
	
	
//	@ExceptionHandler(value = UserEmailAlreadyExistException.class)
//	public ResponseEntity<Object> exception3(UserEmailAlreadyExistException exception) {
//
//		return new ResponseEntity<>(" User already exist with the mail Id !! ", HttpStatus.NOT_FOUND);
//
//	}
//	
//	
//	@ExceptionHandler(value = UserNameException.class)
//	public ResponseEntity<Object> exception3(UserNameException exception) {
//
//		return new ResponseEntity<>(" User already exist with the userNAme Id !! ", HttpStatus.NOT_FOUND);
//
//	}
	
	@ExceptionHandler(value = UserDoesNotExist.class)
	public ResponseEntity<Object> exception4(UserDoesNotExist exception) {

		return new ResponseEntity<>(" user does not exist !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = InvalidEmailAndPassword.class)
	public ResponseEntity<Object> exception4(InvalidEmailAndPassword exception) {

		return new ResponseEntity<>(" Inavlid mai-Id and password ", HttpStatus.NOT_FOUND);

	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
