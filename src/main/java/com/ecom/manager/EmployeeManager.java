package com.ecom.manager;

import java.util.List;

import com.ecom.dto.EmployeeDto;

/**
 * @author pratay.roy
 */
public interface EmployeeManager {
	/**
	 * Method to get all employees
	 * 
	 * @return list of employees
	 */
	public List<EmployeeDto> getAllEmployees();

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
