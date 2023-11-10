package com.ecom.dto;

import java.sql.Date;

/**
 * Order's Dto Class
 * 
 * @author pratay.roy
 */

public class OrderDto {
	private Integer pkOrderId;
	private CustomerDto customer;
	private EmployeeDto employee;
	private Date orderDate;
	private ShipperDto shipper;

	public Integer getPkOrderId() {
		return pkOrderId;
	}

	public void setPkOrderId(Integer pkOrderId) {
		this.pkOrderId = pkOrderId;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public ShipperDto getShipper() {
		return shipper;
	}

	public void setShipper(ShipperDto shipper) {
		this.shipper = shipper;
	}

	public OrderDto() {
		super();
	}

	public OrderDto(Integer pkOrderId, CustomerDto customer, EmployeeDto employee, Date orderDate, ShipperDto shipper) {
		this.pkOrderId = pkOrderId;
		this.customer = customer;
		this.employee = employee;
		this.orderDate = orderDate;
		this.shipper = shipper;
	}

	public void initialize() {
		customer = new CustomerDto();
		employee = new EmployeeDto();
		shipper = new ShipperDto();
	}
}
