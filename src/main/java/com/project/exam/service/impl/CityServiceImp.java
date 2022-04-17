package com.project.exam.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.CityDao;
import com.project.exam.dao.imp.JpaCityDaoImp;
import com.project.exam.domain.City;
import com.project.exam.persistance.MyEntityManagerFactory;
import com.project.exam.service.CityService;

public class CityServiceImp implements CityService{
	EntityManager em;
	CityDao cityDao;
	public CityServiceImp() {

		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		cityDao = new JpaCityDaoImp(em);
	}
	public  List<City> findAll() {
		
		return cityDao.findAll();
	}
	@Override
	public void insertCity(City city) {

		em.getTransaction().begin();
		cityDao.insertCity(city);
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public Boolean removeCity(Long idToRemove) {
		em.getTransaction().begin();
		Boolean isRemoved = cityDao.remove(idToRemove);
		em.getTransaction().commit();
		em.close();
		return isRemoved;
	}

}
