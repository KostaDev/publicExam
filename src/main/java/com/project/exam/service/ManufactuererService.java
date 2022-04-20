package com.project.exam.service;

import java.util.List;

import com.project.exam.domain.Manufacturer;

public interface ManufactuererService {
	List<Manufacturer> findAll();

	Boolean insert(Manufacturer manufacturer);
}
