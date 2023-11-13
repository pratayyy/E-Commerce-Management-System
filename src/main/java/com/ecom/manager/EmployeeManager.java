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
	 * Method to add a new employee
	 * 
	 * @param employee
	 * @return result
	 */
	public Integer addNewEmployee(Employee employee);

	/**
	 * Method to add new employee(s)
	 * 
	 * @param employee
	 * @return result
	 */
	public Integer addNewEmployees(List<Employee> employees);

	/**
	 * Method to update a existing employee using employee ID
	 * 
	 * @param employeeId
	 * @param employee
	 * @return result
	 */
	public Integer updateEmployee(Integer employeeId, Employee emp);

	/**
	 * Method to delete a existing employee using employee ID
	 * 
	 * @param employeeId
	 * @return result
	 */
	public Integer deleteEmployee(Integer employeeId);

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
