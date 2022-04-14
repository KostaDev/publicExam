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
		return loadCities();
	}
	public static CityStorage getInstance() {
		if (instance == null) {
			instance = new CityStorage();
		}
		return instance;
	}

	public void add(City city) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory()
				.createEntityManager();
		em.getTransaction().begin();
		
		City existingCity = em.find(City.class, city.getZipCode());
		if (existingCity==null) {
			em.persist(city);
			System.out.println("City inserted");
		} else {
			existingCity.setName(city.getName());
		}
		em.getTransaction().commit();
		em.close();
	}

	public Boolean delete(Long idToRemove) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory()
				.createEntityManager();
		em.getTransaction().begin();
		City cityToRemove = em.find(City.class,idToRemove);
		if(cityToRemove == null) {
			em.getTransaction().commit();
			return false;
		}
		em.remove(cityToRemove);
		em.getTransaction().commit();
		return true;
	}
}
