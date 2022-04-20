package com.project.exam.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.CityDao;
import com.project.exam.dao.ManufacturerDao;
import com.project.exam.dao.imp.JpaCityDaoImp;
import com.project.exam.dao.imp.JpaManufacturerDaoImp;
import com.project.exam.domain.City;
import com.project.exam.domain.Manufacturer;
import com.project.exam.persistance.MyEntityManagerFactory;
import com.project.exam.service.ManufactuererService;

public class ManufacturerServiceImp implements ManufactuererService {
	EntityManager em;
	ManufacturerDao manufacturerDao;
	CityDao cityDao;
	public ManufacturerServiceImp() {
		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		manufacturerDao = new JpaManufacturerDaoImp(em);
		cityDao = new JpaCityDaoImp(em);
	}
	@Override
	public List<Manufacturer> findAll() {
		List<Manufacturer> manufacturers = manufacturerDao.findAll();
		
		return manufacturers;
	}
	@Override
	public Boolean insert(Manufacturer manufacturer) {
		em.getTransaction().begin();
		try {
			City city = cityDao.findById(manufacturer.getCity().getZipCode());
			manufacturer.setCity(city);
			manufacturerDao.insert(manufacturer);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			em.close();
			return false;
		}
		
		
	}
}
