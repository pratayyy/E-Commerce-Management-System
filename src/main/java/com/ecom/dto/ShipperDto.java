package com.ecom.dto;

/**
 * Shipper's Dto Class
 * 
 * @author pratay.roy
 */

public class ShipperDto {
	private Integer shipperId;
	private String shipperName;
	private String phone;

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ShipperDto() {
		super();
	}

	public ShipperDto(Integer shipperId, String shipperName, String phone) {
		this.shipperId = shipperId;
		this.shipperName = shipperName;
		this.phone = phone;
	}

}
