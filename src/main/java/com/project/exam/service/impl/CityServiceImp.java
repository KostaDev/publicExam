package com.project.exam.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.CityDao;
import com.project.exam.dao.ManufacturerDao;
import com.project.exam.dao.imp.JpaCityDaoImp;
import com.project.exam.dao.imp.JpaManufacturerDaoImp;
import com.project.exam.domain.City;
import com.project.exam.persistance.MyEntityManagerFactory;
import com.project.exam.service.CityService;

public class CityServiceImp implements CityService{
	EntityManager em;
	CityDao cityDao;
	ManufacturerDao manufacturerDao;
	public CityServiceImp() {

		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		cityDao = new JpaCityDaoImp(em);
		manufacturerDao = new JpaManufacturerDaoImp(em);
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
		try {	
		Boolean updateManufacturers = manufacturerDao.removeCity(idToRemove);
		Boolean isRemoved = cityDao.remove(idToRemove);
		em.getTransaction().commit();
		em.close();
		return (isRemoved && updateManufacturers);
		} catch (Exception e) {
			System.out.println("+++++++++++++++++FAILED+++++++++++RIP++++++++++++++");
			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			System.out.println("+++++++++++++++++FAILED+++++++++++RIP++++++++++++++");
			return false;
		}
	}

}
