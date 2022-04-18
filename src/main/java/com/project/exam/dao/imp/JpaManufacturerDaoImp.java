package com.project.exam.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.exam.dao.ManufacturerDao;
import com.project.exam.domain.Manufacturer;

public class JpaManufacturerDaoImp implements ManufacturerDao {
	EntityManager em;

	public JpaManufacturerDaoImp(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Boolean removeCity(Long idToRemove) {
		List<Manufacturer> manufacturers = findAll();
		System.out.println(manufacturers);
		for (Manufacturer manufacturer : manufacturers) {
			if(manufacturer.getCity()==null) {
				continue;
			}
			if (manufacturer.getCity().getZipCode().equals(idToRemove)) {
				manufacturer.setCity(null);
			}
		}
				
		return true;
	}

	public List<Manufacturer> findAll() {
		
		return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();
	}

}
