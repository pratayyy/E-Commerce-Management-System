package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public String getErrorMessage();
}
