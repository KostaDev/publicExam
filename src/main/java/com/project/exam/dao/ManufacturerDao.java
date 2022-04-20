package com.project.exam.dao;

import java.util.List;

import com.project.exam.domain.Manufacturer;

public interface ManufacturerDao {

	

	List<Manufacturer> findAll();

	void insert(Manufacturer manufacturer);

}
