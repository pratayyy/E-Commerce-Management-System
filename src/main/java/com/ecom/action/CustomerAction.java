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
 */
public class CustomerAction {
	private Integer customerId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	private Customer customer;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	private List<Customer> customers;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Map<String, Object> root;

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	private HttpServletResponse response;

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
	public void handleRequest(List<CustomerDto> customers) {
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
	public void handleRequest(CustomerDto customer) {
		if (customer == null) {
			root.put("message", customerManager.getErrorMessage());
			response.setStatus(customerManager.getStatusCode());
		} else {
			root.put("customer", customer);
		}
	}

	/**
	 * Method to get all customers
	 * 
	 * @return success
	 */
	public String readAll() {
		List<CustomerDto> customers = customerManager.getAllCustomers();
		handleRequest(customers);
		return "success";
	}

	/**
	 * Method to get customer by ID
	 * 
	 * @return success
	 */
	public String readById() {
		CustomerDto customer = customerManager.getCustomerById(customerId);
		handleRequest(customer);
		return "success";
	}
}
