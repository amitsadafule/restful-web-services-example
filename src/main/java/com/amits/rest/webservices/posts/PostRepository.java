package com.amits.rest.webservices.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amit Sadafule
 *
 * 08-Nov-2018
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
