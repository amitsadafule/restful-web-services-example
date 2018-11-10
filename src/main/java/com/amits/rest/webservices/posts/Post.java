package com.amits.rest.webservices.posts;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.amits.rest.webservices.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Amit Sadafule
 *
 *         08-Nov-2018
 */
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, max=160, message="description must have min 2 and max 160 characters")
	@ApiModelProperty(notes="description must have min 2 and max 160 characters")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	private Post() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
