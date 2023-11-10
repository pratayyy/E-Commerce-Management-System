package com.ecom.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shipper Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "shipper")
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_shipper_id")
	private Integer pkShipperId;

	@Column(name = "shipper_name")
	private String shipperName;

	private String phone;

	@Column(name = "is_deleted")
	private Integer isDeleted;

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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Shipper() {
		super();
	}

	public Shipper(Integer pkShipperId, String shipperName, String phone, Integer isDeleted) {
		this.pkShipperId = pkShipperId;
		this.shipperName = shipperName;
		this.phone = phone;
		this.isDeleted = isDeleted;
	}

}
