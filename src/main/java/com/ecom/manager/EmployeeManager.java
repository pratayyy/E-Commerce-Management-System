package com.ecom.manager;

import java.util.List;

import com.ecom.dto.EmployeeDto;
import com.ecom.pojo.Employee;

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
	 * Method to get employee using employee ID
	 * 
	 * @param employeeId
	 * @return employee
	 */
	public EmployeeDto getEmployeeById(Integer employeeId);

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
