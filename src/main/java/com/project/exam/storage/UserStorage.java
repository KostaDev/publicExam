package com.project.exam.storage;

import java.util.ArrayList;
import java.util.List;

import com.project.exam.domain.User;



public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	
	public UserStorage() {
		users = new ArrayList() {
			{
				add(new User("user1", "user1", "user 1", "user 1"));
				add(new User("user2", "user2", "user 2", "user 2"));
				add(new User("user3", "user3", "user 3", "user 3"));
			}
		};
	}
	
	public static UserStorage getInstance() {
		if (instance == null) instance = new UserStorage();
		return instance;
	}
	
	public void add(User user) {
		users.add(user);
	}
		
	public List<User> getUsers() {
		return users;
	}
}
