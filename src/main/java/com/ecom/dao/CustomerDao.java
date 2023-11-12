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
	 * Method to get list of customers by country names
	 * 
	 * @param countries
	 * @return customers
	 */
	public List<Customer> getAllCustomersByCountries(List<String> countries);

	/**
	 * Method to add a new customer
	 * 
	 * @param customer
	 * @return result
	 */
	public Integer addNewCustomer(Customer customer);

	/**
	 * Method to add customer(s)
	 * 
	 * @param customers
	 * @return result
	 */
	public Integer addNewCustomers(List<Customer> customers);

	/**
	 * Method to update customer using customer ID and appropriate data
	 * 
	 * @param customerId
	 * @param customerNewValues
	 * @return result
	 */
	public Integer updateCustomer(Integer customerId, Customer customerNewValues);

	/**
	 * Method to delete a existing customer using Customer ID
	 * 
	 * @param customerId
	 * @return result
	 */
	public Integer deleteCustomerById(Integer customerId);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();
}
