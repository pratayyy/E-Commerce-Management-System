package com.ecom.manager;

import java.util.List;

import com.ecom.dto.CustomerDto;
import com.ecom.pojo.Customer;

/**
 * @author pratay.roy
 */
public interface CustomerManager {
	/**
	 * Method to get all customers
	 * 
	 * @return list of customers
	 */
	public List<CustomerDto> getAllCustomers();

	/**
	 * Method to get customer by ID
	 * 
	 * @param customerId
	 * @return customer
	 */
	public CustomerDto getCustomerById(Integer customerId);

	/**
	 * Method to get all customers by specific country names
	 * 
	 * @param countries
	 * @return list of customers
	 */
	public List<CustomerDto> getAllCustomersByCountries(List<String> countries);

	/**
	 * Method to add a new customer
	 * 
	 * @param customer
	 * @return result
	 */
	public Integer addNewCustomer(Customer customer);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();

	/**
	 * Method to get response body
	 * 
	 * @return statusCode
	 */
	public Integer getStatusCode();
}
