package com.ecom.dto;

/**
 * Customer's DTO class
 * 
 * @author pratay.roy
 */

public class CustomerDto {
	private Integer customerId;
	private String customerName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setPkCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public CustomerDto() {
		super();
	}

	public CustomerDto(Integer customerId, String customerName, String contactName, String address, String city,
			String postalCode, String country) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

}
