package com.ecom.managerImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.CustomerDao;
import com.ecom.dto.CustomerDto;
import com.ecom.manager.CustomerManager;
import com.ecom.pojo.Customer;
import com.ecom.util.Mapper;

/**
 * @author pratay.roy
 */
public class CustomerManagerImpl implements CustomerManager {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	private String errorMessage;
	private Integer statusCode;

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerDao.getAllCustomers();
		// If there are customer(s) present then map them to the customerDTO to get the
		// required values
		if (customers.isEmpty()) {
			statusCode = 404;
			errorMessage = "Customers doesnot exist";
		}
		return customers.isEmpty() ? null
				: customers.stream().map(customer -> Mapper.customerDtoMapper(customer)).collect(Collectors.toList());
	}

	@Override
	public CustomerDto getCustomerById(Integer customerId) {
		// Customer ID is not valid
		if (customerId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Customer ID";
			return null;
		}
		Customer customer = customerDao.getCustomerById(customerId);
		// Customer doesnot exist
		if (customer == null) {
			statusCode = 404;
			errorMessage = "Customer with provided Customer ID doesnot exist";
		}
		return customer == null ? null : Mapper.customerDtoMapper(customer);
	}

	@Override
	public List<CustomerDto> getAllCustomersByCountries(List<String> countries) {
		// Customers not provided
		if (countries == null || countries.isEmpty()) {
			statusCode = 400;
			errorMessage = "Countries list is empty";
			return null;
		}
		List<Customer> customers = customerDao.getAllCustomersByCountries(countries);
		// No customers are available in the seleted countries
		if (customers.isEmpty()) {
			statusCode = 404;
			errorMessage = "Customers doesnot exist in these countries";
		}
		return customers.isEmpty() ? null
				: customers.stream().map(customer -> Mapper.customerDtoMapper(customer)).collect(Collectors.toList());
	}

	@Override
	public Integer addNewCustomer(Customer customer) {
		// Customer entries are null
		if (customer.getCustomerName() == null || customer.getContactName() == null || customer.getCountry() == null) {
			statusCode = 400;
			errorMessage = "Customer entries are not defined";
			return 0;
		}
		return customerDao.addNewCustomer(customer);
	}

	@Override
	public Integer addNewCustomers(List<Customer> customers) {
		// Empty list of customers
		if (customers.isEmpty()) {
			statusCode = 400;
			errorMessage = "Customers list is empty";
			return 0;
		}
		return customerDao.addNewCustomers(customers);
	}

	@Override
	public Integer updateCustomer(Integer customerId, Customer customerNewValues) {
		if (customerId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Customer ID";
			return 0;
		}
		if (customerNewValues.getCustomerName() == null && customerNewValues.getContactName() == null
				&& customerNewValues.getAddress() == null && customerNewValues.getCountry() == null
				&& customerNewValues.getCity() == null && customerNewValues.getPostalCode() == null) {
			statusCode = 400;
			errorMessage = "No entries to update provided";
			return 0;
		}
		if (customerDao.getCustomerById(customerId) == null) {
			statusCode = 404;
			errorMessage = "Customer with provided Customer ID doesnot exist";
			return 0;
		}
		return customerDao.updateCustomer(customerId, customerNewValues);
	}

	@Override
	public Integer deleteCustomerById(Integer customerId) {
		if (customerId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Customer ID";
			return 0;
		}
		if (customerDao.getCustomerById(customerId) == null) {
			statusCode = 404;
			errorMessage = "Customer with provided Customer ID doesnot exist";
			return 0;
		}
		return customerDao.deleteCustomerById(customerId);
	}

	@Override
	public Integer deleteCustomersByCountries(List<String> countries) {
		// Empty list of countries
		if (countries.isEmpty()) {
			statusCode = 400;
			errorMessage = "Countries list is empty";
			return 0;
		}
		Integer result = customerDao.deleteCustomersByCountries(countries);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "Customer doesnot exist for the given countries";
		}
		return result;
	}

	@Override
	public String getErrorMessage() {
		String daoErrorMessage = customerDao.getErrorMessage();
		// If there is error show that message else null
		return daoErrorMessage != null ? daoErrorMessage : errorMessage;
	}

	@Override
	public Integer getStatusCode() {
		String daoErrorMessage = customerDao.getErrorMessage();
		// If there is a error show default 500 else statusCode received
		return daoErrorMessage != null ? 500 : statusCode;
	}

}
