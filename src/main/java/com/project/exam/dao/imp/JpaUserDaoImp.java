package com.project.exam.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.UserDao;
import com.project.exam.domain.User;

public class JpaUserDaoImp implements UserDao{
	private EntityManager em;
	public JpaUserDaoImp(EntityManager em) {
		this.em = em;
		
	}
	
	@Override
	public List<User> findAll() {
		
		return em.createNamedQuery("User.findAll", User.class).getResultList();
	}

}
