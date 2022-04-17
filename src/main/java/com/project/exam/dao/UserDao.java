package com.project.exam.dao;

import java.util.List;

import com.project.exam.domain.User;

public interface UserDao {
	List<User> findAll();
}
