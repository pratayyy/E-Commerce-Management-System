package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.Employee;

/**
 * @author pratay.roy
 */
public interface EmployeeDao {
	/**
	 * Method to get all the employees
	 * 
	 * @return list of employees
	 */
	public List<Employee> getAllEmployees();

	/**
	 * Method to get employee using employee ID
	 * 
	 * @param employeeId
	 * @return employee
	 */
	public Employee getEmployeeById(Integer employeeId);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();
}
