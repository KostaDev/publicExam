package com.project.exam.domain;

import javax.persistence.*;



@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City {
	@Id
	@Column(name = "zip_code")
	private Long zipCode;
	
	@Column(name = "name")
	private String name;
	
	public City() {
	}
	
	public City(Long zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}

	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [zipCode=" + zipCode + ", name=" + name + "]";
	}
}
