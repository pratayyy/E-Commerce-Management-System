package com.ecom.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom.dao.EmployeeDao;

/**
 * @author pratay.roy
 */
public class EmployeeDaoImpl implements EmployeeDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	private String errorMessage;
	private Integer result = 0;

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
