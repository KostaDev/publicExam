package com.project.exam.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.ManufacturerDao;
import com.project.exam.domain.City;
import com.project.exam.domain.Manufacturer;

public class JpaManufacturerDaoImp implements ManufacturerDao {
	EntityManager em;

	public JpaManufacturerDaoImp(EntityManager em) {
		this.em = em;
	}
	
	

	public List<Manufacturer> findAll() {
		
		return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();
	}
	@Override
	public void insert(Manufacturer manufacturer) {
		City c = em.find(City.class, manufacturer.getCity().getZipCode());
		manufacturer.setCity(c);
		em.merge(manufacturer);
		
	}
	

}
