package com.amits.rest.webservices.posts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Amit Sadafule
 *
 * 08-Nov-2018
 */
@Component
public class PostDAOService {

	private static Map<Integer, List<Post>> posts = new HashMap<Integer, List<Post>>();
	private static int postCounter = 0;
	
	public List<Post> findAllForUser(Integer userId) {
		List<Post> userPosts = posts.get(userId);
		if(userPosts == null)
			return new ArrayList<Post>();
		return userPosts;
	}
	
	public Post findPostByUserIdAndPostId(Integer userId, Integer postId) {
		List<Post> userPosts = posts.get(userId);
		if(userPosts == null){
			return null;
		}
		return userPosts
					.stream()
					.filter(post -> post.getPostId().equals(postId))
					.findFirst()
					.orElse(null);
	}
	
	public Post createPost(Post post) {
		if(post.getPostId() == null) {
			post.setPostId(++postCounter);
		}
		
		List<Post> userPosts = findAllForUser(post.getUserId());
		userPosts.add(post);
		posts.put(post.getUserId(), userPosts);
		return post;
	}
}
