package com.project.exam.service;

import java.util.List;

import com.project.exam.domain.City;

public interface CityService {
	List<City> findAll();

	void insertCity(City city);

	Boolean removeCity(Long idToRemove);
}
