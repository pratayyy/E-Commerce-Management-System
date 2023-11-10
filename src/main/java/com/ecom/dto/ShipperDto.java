package com.ecom.dto;

/**
 * Shipper's Dto Class
 * 
 * @author pratay.roy
 */

public class ShipperDto {
	private Integer pkShipperId;
	private String shipperName;
	private String phone;

	public Integer getPkShipperId() {
		return pkShipperId;
	}

	public void setPkShipperId(Integer pkShipperId) {
		this.pkShipperId = pkShipperId;
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

	public ShipperDto(Integer pkShipperId, String shipperName, String phone) {
		this.pkShipperId = pkShipperId;
		this.shipperName = shipperName;
		this.phone = phone;
	}

}
