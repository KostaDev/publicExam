package com.project.exam.persistance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private static MyEntityManagerFactory instance;
	private EntityManagerFactory emf;
	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("com.project.exam");	
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (instance == null) {
			instance = new MyEntityManagerFactory();
			
		}
		return instance.getEmf();
	}

	private EntityManagerFactory getEmf() {
		
		return emf;
	}
	public static void closeEntityManagerFactory() {
		if (instance !=null) {
			instance.getEmf().close();
		}
	}
}
