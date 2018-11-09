package com.amits.rest.webservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Amit Sadafule
 *
 * 07-Nov-2018
 */
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Amit", new Date()));
		users.add(new User(2, "Naval", new Date()));
		users.add(new User(3, "Saurabh", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(Integer id) {
		return users
			.stream()
			.filter(user -> user.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
	
	public User deleteUserById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId().equals(id)) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
