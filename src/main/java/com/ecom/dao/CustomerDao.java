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
	 * Method to get customer by customer ID
	 * 
	 * @param customerId
	 * @return customer
	 */
	public Customer getCustomerById(Integer customerId);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();
}
