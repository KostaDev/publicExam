package com.project.exam.domain;

import javax.persistence.*;

/**
 * @author Kosta
 *
 */
@Entity
@NamedQuery(name="Manufacturer.findAll", query="SELECT m FROM Manufacturer m")
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manufacturer_id")
	private Long manufacturerId;
	@Column(name = "tax_id")
	private Long taxId;
	
	private String adress;
	@ManyToOne
	@JoinColumn(name="city", referencedColumnName = "zip_code")
	private City city;
	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}
	
	public Manufacturer(Long manufacturerId, Long taxId, String adress, City city) {
		super();
		this.manufacturerId = manufacturerId;
		this.taxId = taxId;
		this.adress = adress;
		this.city = city;
	}

	public Manufacturer(Long taxId, String adress, City city) {
		super();
		this.taxId = taxId;
		this.adress = adress;
		this.city = city;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public Long getTaxId() {
		return taxId;
	}
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", taxId=" + taxId + ", adress=" + adress + ", city="
				+ city + "]";
	}
	
	
	
}
