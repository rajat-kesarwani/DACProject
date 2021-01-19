package com.app.GlobalException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.CustomExp.ResourceNotFoundException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // stereotype annotation . Class level annotation .
//Supplies common advice to all controllers  n rest controllers.
public class GlobalExceptionHandler // extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exc, WebRequest request) {
		System.out.println("In Result Not Found Exception");
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), request.getDescription(false), "error");
		return new ResponseEntity<>(errResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationExc(ConstraintViolationException e, WebRequest request) {
		System.out.println("in exc 2!!!");
		ErrorResponse errResp = new ErrorResponse(e.getMessage(), request.getDescription(false), "erorr");
		return new ResponseEntity<>(errResp, HttpStatus.BAD_REQUEST);
	}

	// This Exception is thrown when a method argument fails validation typically
	// due to @Valid style validation
	// or request body content is required.
//	@Override
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
		System.out.println("In Method Argument Not Valid");

		/*
		 * List<String> validationErrs = ex.getBindingResult().getFieldErrors().stream()
		 * .map(fieldErr -> fieldErr.getDefaultMessage()).collect(Collectors.toList());
		 */
		List<String> validationErrs = new ArrayList<>();
		// BindingResult : i/f : represents results of binding between request data n
		// pojo properties
		for (FieldError err : ex.getBindingResult().getFieldErrors())
			validationErrs.add(err.getDefaultMessage());// adds def error messages from binding results

		ErrorResponse errResp = new ErrorResponse("Validation Failed", validationErrs.toString(), "error");
		return new ResponseEntity<Object>(errResp, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Object> NoResultException(MethodArgumentNotValidException ex, WebRequest request) {
		System.out.println("In No Result Exception");

		List<String> validationErrs = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldErr -> fieldErr.getDefaultMessage()).collect(Collectors.toList());
		ErrorResponse errResp = new ErrorResponse("No Result Found", validationErrs.toString(), "error");
		return new ResponseEntity<Object>(errResp, HttpStatus.NO_CONTENT);

	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> IllegalArgumentException(MethodArgumentNotValidException ex, WebRequest request) {
		System.out.println("In IllegalArgument Exception");

		List<String> validationErrs = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldErr -> fieldErr.getDefaultMessage()).collect(Collectors.toList());
		ErrorResponse errResp = new ErrorResponse("Illegal Argument", validationErrs.toString(), "error");
		return new ResponseEntity<Object>(errResp, HttpStatus.BAD_REQUEST);
	}
	// handle ANY exception -- equivalent to catch-all
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAnyException(Exception exc, WebRequest request) {
		System.out.println("In Catch All Exception");
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), request.getDescription(false), "error");
		return new ResponseEntity<>(errResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
