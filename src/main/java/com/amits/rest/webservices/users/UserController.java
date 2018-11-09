package com.amits.rest.webservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amits.rest.webservices.exceptions.UserNotFoundException;

/**
 * @author Amit Sadafule
 *
 *         07-Nov-2018
 */
@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> returnAllUsers() {
		List<User> users = service.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("No user found");
		}

		return users;
	}

	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null) {
			throw new UserNotFoundException(String.format(
					"user with id = %d is not found", id));
		}

		//HATEOAS
		Resource<User> resource = new Resource<User>(user);

		resource.add(
				linkTo(methodOn(this.getClass()).returnAllUsers())
					.withRel("all-users")
					);
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createdUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteUserById(id);

		if (user == null) {
			throw new UserNotFoundException(String.format(
					"user with id = %d is not found", id));
		}
	}
}
