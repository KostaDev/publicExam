package com.project.exam.dao;

import java.util.List;

import com.project.exam.domain.City;

public interface CityDao {
	List<City> findAll();

	void insertCity(City city);

	Boolean remove(Long idToRemove);
}
