package com.ecom.manager;

import java.util.List;

import com.ecom.dto.CustomerDto;

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
