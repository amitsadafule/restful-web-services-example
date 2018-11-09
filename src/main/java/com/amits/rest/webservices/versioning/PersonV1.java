package com.amits.rest.webservices.versioning;

/**
 * @author Amit Sadafule
 *
 * 09-Nov-2018
 */
public class PersonV1 {

	private String name;

	public PersonV1() {
		super();
	}
	
	/**
	 * @param name
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
