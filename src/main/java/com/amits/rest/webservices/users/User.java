package com.amits.rest.webservices.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author Amit Sadafule
 *
 * 07-Nov-2018
 */
@ApiModel(description="This is user POJO")
public class User {

	private Integer id;
	
	@Size(min = 2, message="Name must have min 2 characters")
	@Size(max = 10, message="Name must have max 10 characters")
	@ApiModelProperty(notes="Name must have min 2 and max 10 characters")
	private String name;
	
	@Past(message="birth date must be in past")
	@ApiModelProperty(notes="birth date must be in past")
	private Date birthDate;
	
	private User() {}
	
	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
