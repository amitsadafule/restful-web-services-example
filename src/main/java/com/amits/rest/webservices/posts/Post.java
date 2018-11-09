package com.amits.rest.webservices.posts;

/**
 * @author Amit Sadafule
 *
 * 08-Nov-2018
 */
public class Post {

	private Integer userId;
	private Integer postId;
	private String message;
	
	private Post(){}
	
	/**
	 * @param userId
	 * @param postId
	 * @param message
	 */
	public Post(Integer userId, Integer postId, String message) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.message = message;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
