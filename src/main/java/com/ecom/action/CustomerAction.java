package com.ecom.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecom.dto.CustomerDto;
import com.ecom.manager.CustomerManager;
import com.ecom.pojo.Customer;

/**
 * @author pratay.roy
 * @version 0.0.1
 */
public class CustomerAction {
	private Integer customerId;
	private List<String> countries;
	private Customer customer;
	private List<Customer> customers;
	private Map<String, Object> root;
	private HttpServletResponse response;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	private CustomerManager customerManager;

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	/**
	 * Constructor to get beans and response body initializations
	 */
	public CustomerAction() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			customerManager = (CustomerManager) context.getBean("customerManager");
		} catch (Exception e) {
			e.printStackTrace();
		}
		root = new HashMap<String, Object>();
		response = ServletActionContext.getResponse();
	}

	/**
	 * Method to set response when receiving a list of customers as output
	 * 
	 * @param customers
	 */
	public void handleResponse(List<CustomerDto> customers) {
		if (customers == null) {
			root.put("message", customerManager.getErrorMessage());
			response.setStatus(customerManager.getStatusCode());
		} else {
			root.put("customers", customers);
		}
	}

	/**
	 * Method to set response when receiving a customer as output
	 * 
	 * @param customer
	 */
	public void handleResponse(CustomerDto customer) {
		if (customer == null) {
			root.put("message", customerManager.getErrorMessage());
			response.setStatus(customerManager.getStatusCode());
		} else {
			root.put("customer", customer);
		}
	}

	/**
	 * Method to set response on result type
	 * 
	 * @param result
	 */
	public void handleResponse(int result) {
		root.put("result", result);
		if (result == 0) {
			root.put("message", customerManager.getErrorMessage());
			response.setStatus(customerManager.getStatusCode());
		}
	}

	/**
	 * Method to get all customers
	 * 
	 * @return success
	 */
	public String readAll() {
		List<CustomerDto> customers = customerManager.getAllCustomers();
		handleResponse(customers);
		return "success";
	}

	/**
	 * Method to get customer by ID
	 * 
	 * @return success
	 */
	public String readById() {
		CustomerDto customer = customerManager.getCustomerById(customerId);
		handleResponse(customer);
		return "success";
	}

	/**
	 * Method to get all customers using country names
	 * 
	 * @return success
	 */
	public String readByCountries() {
		List<CustomerDto> customers = customerManager.getAllCustomersByCountries(countries);
		handleResponse(customers);
		return "success";
	}

	/**
	 * Method to add new customer
	 * 
	 * @return success
	 */
	public String addCustomer() {
		Integer result = customerManager.addNewCustomer(customer);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to add new customer(s)
	 * 
	 * @return success
	 */
	public String addCustomers() {
		Integer result = customerManager.addNewCustomers(customers);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update customer using customer ID and appropriate data
	 * 
	 * @return success
	 */
	public String updateCustomer() {
		Integer result = customerManager.updateCustomer(customerId, customer);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to delete customer using customer ID
	 * 
	 * @return success
	 */
	public String deleteById() {
		Integer result = customerManager.deleteCustomerById(customerId);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to delete all customers by given country names
	 * 
	 * @return success
	 */
	public String deleteByCountries() {
		Integer result = customerManager.deleteCustomersByCountries(countries);
		handleResponse(result);
		return "success";
	}
}
