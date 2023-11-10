package com.ecom.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Supplier Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_supplier_id")
	private Integer pkSupplierId;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "contact_name")
	private String contactName;

	private String address;
	private String city;

	@Column(name = "postal_code")
	private String postalCode;

	private String country;
	private String phone;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkSupplierId() {
		return pkSupplierId;
	}

	public void setPkSupplierId(Integer pkSupplierId) {
		this.pkSupplierId = pkSupplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Supplier() {
		super();
	}

	public Supplier(Integer pkSupplierId, String supplierName, String contactName, String address, String city,
			String postalCode, String country, String phone, Integer isDeleted) {
		this.pkSupplierId = pkSupplierId;
		this.supplierName = supplierName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.isDeleted = isDeleted;
	}

}
