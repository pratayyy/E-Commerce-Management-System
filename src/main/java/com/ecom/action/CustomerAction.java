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

public class CustomerAction {
	private Customer customer;
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

	public CustomerAction() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			customerManager = (CustomerManager) context.getBean("customerManager");
		} catch (Exception e) {
			e.printStackTrace();
		}
		root = new HashMap<String, Object>();
		response = ServletActionContext.getResponse();
	}

	public void handleRequest(List<CustomerDto> customers) {
		if (customers == null) {
			root.put("message", customerManager.getErrorMessage());
			response.setStatus(customerManager.getStatusCode());
		} else {
			root.put("customers", customers);
		}
	}

	public String readAll() {
		List<CustomerDto> customers = customerManager.getAllCustomers();
		handleRequest(customers);
		return "success";
	}
}
