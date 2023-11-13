package com.ecom.dto;

/**
 * Supplier's Dto Class
 * 
 * @author pratay.roy
 */

public class SupplierDto {
	private Integer supplierId;
	private String supplierName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	private String phone;

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setPkSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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

	public SupplierDto() {
		super();
	}

	public SupplierDto(Integer supplierId, String supplierName, String contactName, String address, String city,
			String postalCode, String country, String phone) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
	}

}
