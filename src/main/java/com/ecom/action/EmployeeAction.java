package com.ecom.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecom.dto.EmployeeDto;
import com.ecom.manager.EmployeeManager;
import com.ecom.pojo.Employee;

/**
 * @author pratay.roy
 */
public class EmployeeAction {
	private Integer employeeId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	private Map<String, Object> root;

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	private HttpServletResponse response;

	private EmployeeManager employeeManager;

	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	/**
	 * Constructor to get beans and response body initializations
	 */
	public EmployeeAction() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			employeeManager = (EmployeeManager) context.getBean("employeeManager");
		} catch (Exception e) {
			e.printStackTrace();
		}
		root = new HashMap<String, Object>();
		response = ServletActionContext.getResponse();
	}

	/**
	 * Method to set response when receiving a list of employees as output
	 * 
	 * @param employees
	 */
	public void hanleResponse(List<EmployeeDto> employees) {
		if (employees == null) {
			root.put("message", employeeManager.getErrorMessage());
			response.setStatus(employeeManager.getStatusCode());
		} else {
			root.put("employees", employees);
		}
	}

	/**
	 * Method to set response when receiving a single employee as output
	 * 
	 * @param employee
	 */
	public void handleResponse(EmployeeDto employee) {
		if (employee == null) {
			root.put("message", employeeManager.getErrorMessage());
			response.setStatus(employeeManager.getStatusCode());
		} else {
			root.put("employee", employee);
		}
	}

	/**
	 * Method to set response when recieving result as output
	 * 
	 * @param result
	 */
	public void handleResponse(Integer result) {
		root.put("result", result);
		if (result == 0) {
			root.put("message", employeeManager.getErrorMessage());
			response.setStatus(employeeManager.getStatusCode());
		}
	}

	/**
	 * Method to get all employees
	 * 
	 * @return success
	 */
	public String readAll() {
		return "success";
	}

	/**
	 * Method to get employee by employee ID
	 * 
	 * @return success
	 */
	public String readById() {
		return "success";
	}

	/**
	 * Method to add a single employee
	 * 
	 * @return success
	 */
	public String addSingle() {
		return "success";
	}

	/**
	 * Method to add multiple employee
	 * 
	 * @return success
	 */
	public String addMutiple() {
		return "success";
	}

	/**
	 * Method to update existing employee
	 * 
	 * @return success
	 */
	public String update() {
		return "success";
	}

	/**
	 * Method to delete existing employee
	 * 
	 * @return success
	 */
	public String delete() {
		return "success";
	}

}
