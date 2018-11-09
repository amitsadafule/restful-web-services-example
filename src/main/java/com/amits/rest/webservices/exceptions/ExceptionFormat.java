package com.amits.rest.webservices.exceptions;

import java.util.Date;

/**
 * @author Amit Sadafule
 *
 *         07-Nov-2018
 */
public class ExceptionFormat {

	private Date date;
	private String message;
	private String details;

	/**
	 * @param date
	 * @param message
	 * @param details
	 */
	public ExceptionFormat(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
