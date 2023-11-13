package com.ecom.managerImpl;

import com.ecom.dao.CustomerDao;
import com.ecom.manager.EmployeeManager;

/**
 * @author pratay.roy
 */
public class EmployeeManagerImpl implements EmployeeManager {
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
