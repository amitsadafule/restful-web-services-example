package com.amits.rest.webservices.helloworld;

/**
 * @author Amit Sadafule
 *
 * 06-Nov-2018
 */
public class HelloWorldBean {

	private String message;

	/**
	 * @param string
	 */
	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
