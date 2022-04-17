package com.project.exam.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.UserDao;
import com.project.exam.dao.imp.JpaUserDaoImp;
import com.project.exam.domain.User;
import com.project.exam.persistance.MyEntityManagerFactory;
import com.project.exam.service.UserService;

public class UserServiceImp implements UserService {
	EntityManager em;
	UserDao userDao;
	public UserServiceImp() {
		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		userDao = new JpaUserDaoImp(em);
	}
	@Override
	public User login(String username, String password) {
		List<User> users = userDao.findAll();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
