package com.amits.rest.webservices.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amits.rest.webservices.exceptions.NoPostForUserFoundException;

/**
 * @author Amit Sadafule
 *
 * 08-Nov-2018
 */
@RestController
public class PostController {

	@Autowired
	private PostRepository service;
	
}
