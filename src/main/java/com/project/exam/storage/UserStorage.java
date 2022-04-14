package com.project.exam.storage;


import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.domain.User;
import com.project.exam.persistance.MyEntityManagerFactory;




public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	
	public UserStorage() {
		users = loadUsers();
		System.out.println("++++++LOADED USERS++++++");
	}
	
	private List<User> loadUsers() {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory()
				.createEntityManager();
		List<User> users = em.createNamedQuery("User.findAll",User.class)
				.getResultList();
		em.close();
		return users;
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
