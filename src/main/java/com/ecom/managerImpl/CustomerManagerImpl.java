package com.ecom.managerImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.CustomerDao;
import com.ecom.dto.CustomerDto;
import com.ecom.manager.CustomerManager;
import com.ecom.pojo.Customer;
import com.ecom.util.Mapper;

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
		return customers == null ? null
				: customers.stream().map(customer -> Mapper.customerDtoMapper(customer)).collect(Collectors.toList());
	}

	@Override
	public String getErrorMessage() {
		String daoErrorMessage = customerDao.getErrorMessage();
		return daoErrorMessage != null ? daoErrorMessage : errorMessage;
	}

	@Override
	public Integer getStatusCode() {
		String daoErrorMessage = customerDao.getErrorMessage();
		return daoErrorMessage != null ? 500 : statusCode;
	}

}
