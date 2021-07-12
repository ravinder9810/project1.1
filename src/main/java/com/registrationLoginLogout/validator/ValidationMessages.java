package com.registrationLoginLogout.validator;

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

import com.registrationLoginLogout.exception.ConfirmPassswordException;
import com.registrationLoginLogout.exception.InvalidEmailAndPassword;
import com.registrationLoginLogout.exception.UserDoesNotExist;
import com.registrationLoginLogout.exception.UserEmailAlreadyExistException;
import com.registrationLoginLogout.exception.UserNameException;


@ControllerAdvice
public class ValidationMessages extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value = UserEmailAlreadyExistException.class)
	public ResponseEntity<Object> exceptionForEmailAreadyExist(UserEmailAlreadyExistException exception) {

		return new ResponseEntity<>(" User already exist with the mail-Id ? Please try with another Email-Id ", HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(value = UserNameException.class)
	public ResponseEntity<Object> exceptionForUserNameAlreadyExist(UserNameException exception) {

		return new ResponseEntity<>(" User already exist with the User-Name ? Please try with another User-Name ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = UserDoesNotExist.class)
	public ResponseEntity<Object> exceptionForUserDoesNotExist(UserDoesNotExist exception) {

		return new ResponseEntity<>(" user does not exist !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = InvalidEmailAndPassword.class)
	public ResponseEntity<Object> exceptionForInvalidEmailAndPassword(InvalidEmailAndPassword exception) {

		return new ResponseEntity<>(" Invalid mail-Id and password ? Please try with Correct Login Credintials", HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(value = ConfirmPassswordException.class)
	public ResponseEntity<Object> exceptionForConfirmPasssword(ConfirmPassswordException exception) {

		return new ResponseEntity<>(" Password and confirm Password Does not Match ?", HttpStatus.NOT_FOUND);

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
