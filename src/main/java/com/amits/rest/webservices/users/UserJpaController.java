package com.amits.rest.webservices.users;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amits.rest.webservices.exceptions.UserNotFoundException;
import com.amits.rest.webservices.posts.Post;
import com.amits.rest.webservices.posts.PostRepository;

/**
 * <strong>DB entities should not be exposed in url e.g. json response.
 * This is just an example to learn restful services. 
 * Ideally, separate pojo should be created for output objects</strong>
 * @author Amit Sadafule
 *
 * 10-Nov-2018
 */
@RestController
public class UserJpaController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public List<User> returnAllUsers() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("No user found");
		}

		return users;
	}

	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException(String.format(
					"user with id = %d is not found", id));
		}

		//HATEOAS
		Resource<User> resource = new Resource<User>(user.get());

		resource.add(
				linkTo(methodOn(this.getClass()).returnAllUsers())
					.withRel("all-users")
					);
		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createdUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable(name="id") int userId) {
		
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			throw new UserNotFoundException(String.format(
					"user with id = %d is not found", userId));
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException(String.format(
					"user with id = %d is not found", id));
		}
		
		post.setUser(user.get());
		post = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
