package com.amits.rest.webservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Amit Sadafule
 *
 * 08-Nov-2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoPostForUserFoundException extends RuntimeException {

	/**
	 * @param message
	 */
	public NoPostForUserFoundException(String message) {
		super(message);
	}
	
}
