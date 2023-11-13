package com.ecom.managerImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.EmployeeDao;
import com.ecom.dto.EmployeeDto;
import com.ecom.manager.EmployeeManager;
import com.ecom.pojo.Employee;
import com.ecom.util.Mapper;

/**
 * @author pratay.roy
 */
public class EmployeeManagerImpl implements EmployeeManager {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	private String errorMessage;
	private Integer statusCode;

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		if (employees.isEmpty()) {
			statusCode = 400;
			errorMessage = "Employees doesnot exist";
		}
		return employees.isEmpty() ? null
				: employees.stream().map(employee -> Mapper.employeeDtoMapper(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		if (employeeId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Employee ID";
			return null;
		}
		Employee employee = employeeDao.getEmployeeById(employeeId);
		if (employee == null) {
			statusCode = 404;
			errorMessage = "Employee with provided Employee ID doesnot exist";
		}
		return employee == null ? null : Mapper.employeeDtoMapper(employee);
	}

	@Override
	public Integer addNewEmployee(Employee employee) {
		if (employee.getFirstName() == null || employee.getLastName() == null) {
			statusCode = 400;
			errorMessage = "Employee entries are not defined";
			return 0;
		}
		return employeeDao.addNewEmployee(employee);
	}

	@Override
	public Integer addNewEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			statusCode = 400;
			errorMessage = "Employees list is empty";
			return 0;
		}
		return employeeDao.addNewEmployees(employees);
	}

	@Override
	public Integer updateEmployee(Integer employeeId, Employee emp) {
		if (employeeId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Employee ID";
			return 0;
		}
		if (emp.getFirstName() == null && emp.getLastName() == null && emp.getBirthDate() == null
				&& emp.getNotes() == null && emp.getPhoto() == null) {
			statusCode = 400;
			errorMessage = "No entries to update provided";
			return 0;
		}
		if (employeeDao.getEmployeeById(employeeId) == null) {
			statusCode = 404;
			errorMessage = "Employee with provided Employee ID doesnot exist";
			return 0;
		}
		return employeeDao.updateEmployee(employeeId, emp);
	}

	@Override
	public String getErrorMessage() {
		String daoErrorMessage = employeeDao.getErrorMessage();
		return daoErrorMessage != null ? daoErrorMessage : errorMessage;
	}

	@Override
	public Integer getStatusCode() {
		String daoErrorMessage = employeeDao.getErrorMessage();
		return daoErrorMessage != null ? 500 : statusCode;
	}
}
