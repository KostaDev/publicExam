package com.project.exam.storage;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.domain.City;
import com.project.exam.persistance.MyEntityManagerFactory;

public class CityStorage {
	private static CityStorage instance;
	private List<City> cities;
	
	private CityStorage() {

		cities = loadCities();
	}

	private List<City> loadCities() {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory()
				.createEntityManager();
 		List<City> listCities = em.createNamedQuery("City.findAll",City.class)
 				.getResultList();
 		em.close();
 		return listCities;
	}
	public List<City> getCities() {
		return cities;
	}
	public static CityStorage getInstance() {
		if (instance == null) {
			instance = new CityStorage();
		}
		return instance;
	}
}
