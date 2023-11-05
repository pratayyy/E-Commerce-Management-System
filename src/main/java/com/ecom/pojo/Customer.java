package com.ecom.pojo;

/**
 * Customer Entity
 * 
 * @author pratay.roy
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_customer_id")
	private Integer pkCustomerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_name")
	private String contactName;

	private String address;
	private String city;

	@Column(name = "postal_code")
	private String postalCode;

	private String country;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkCustomerId() {
		return pkCustomerId;
	}

	public void setPkCustomerId(Integer pkCustomerId) {
		this.pkCustomerId = pkCustomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Customer() {
		super();
	}

	public Customer(Integer pkCustomerId, String customerName, String contactName, String address, String city,
			String postalCode, String country, Integer isDeleted) {
		this.pkCustomerId = pkCustomerId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.isDeleted = isDeleted;
	}

}
