package com.project.exam.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.CityDao;
import com.project.exam.domain.City;

public class JpaCityDaoImp implements CityDao {
	EntityManager em;
	public JpaCityDaoImp(EntityManager em) {
		this.em = em;
	}
	@Override
	public City findById(Long zipCode) {		
		return em.find(City.class, zipCode);
	}
	@Override
	public List<City> findAll() {
		return em.createNamedQuery("City.findAll", City.class).getResultList();
	}
	@Override
	public void insertCity(City city) {

		City existingCity = em.find(City.class, city.getZipCode());
		if (existingCity==null) {
			em.persist(city);
		} else {
			existingCity.setName(city.getName());
		}
	}
	@Override
	public Boolean remove(Long idToRemove) {
		City cityToRemove = em.find(City.class, idToRemove);
		if (cityToRemove==null) {
			return false;
		}
		em.remove(cityToRemove);
		return true;
	}
	
}
