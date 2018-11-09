package com.amits.rest.webservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Amit Sadafule
 *
 *         07-Nov-2018
 */
@ControllerAdvice
@RestController
public class CustomResponseEntitiyExceptionHandler extends
		ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex,
			WebRequest request) {
		ExceptionFormat format = new ExceptionFormat(new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(format,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ UserNotFoundException.class,
			NoPostForUserFoundException.class })
	public ResponseEntity<Object> handleNotFoundExceptions(Exception ex,
			WebRequest request) {
		ExceptionFormat format = new ExceptionFormat(new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(format, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionFormat format = new ExceptionFormat(new Date(),
				"Validation Failed", ex.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<Object>(format, HttpStatus.BAD_REQUEST);
	}
}
