package com.ecom.manager;

import java.util.List;

import com.ecom.dto.CustomerDto;

public interface CustomerManager {
	public List<CustomerDto> getAllCustomers();

	public String getErrorMessage();

	public Integer getStatusCode();
}
