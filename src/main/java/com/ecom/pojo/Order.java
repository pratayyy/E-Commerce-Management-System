package com.ecom.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Order Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_order_id")
	private Integer pkOrderId;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_employee_id", nullable = false)
	private Employee employee;

	@Column(name = "order_date")
	private Date orderDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_shipper_id")
	private Shipper shipper;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkOrderId() {
		return pkOrderId;
	}

	public void setPkOrderId(Integer pkOrderId) {
		this.pkOrderId = pkOrderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Order() {
		super();
	}

	public Order(Integer pkOrderId, Customer customer, Employee employee, Date orderDate, Shipper shipper,
			Integer isDeleted) {
		this.pkOrderId = pkOrderId;
		this.customer = customer;
		this.employee = employee;
		this.orderDate = orderDate;
		this.shipper = shipper;
		this.isDeleted = isDeleted;
	}

}
