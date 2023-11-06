package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.Customer;

/**
 * @author pratay.roy
 */
public interface CustomerDao {
	/**
	 * Method to get all customers
	 * 
	 * @return list of customers
	 */
	public List<Customer> getAllCustomers();

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();
}
