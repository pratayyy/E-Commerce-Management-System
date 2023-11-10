package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecom.dao.CustomerDao;
import com.ecom.pojo.Customer;

/**
 * @author pratay.roy
 */
public class CustomerDaoImpl implements CustomerDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	private Configuration configuration;
	private String errorMessage;

	// Constructor to set the hibernate configs from configuration file
	public CustomerDaoImpl() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getAllCustomerQuery = new StringBuilder("FROM Customer c");
			getAllCustomerQuery.append(" WHERE c.isDeleted = :isDeleted");
			query = session.createQuery(getAllCustomerQuery.toString());
			query.setParameter("isDeleted", -1);
			customers = query.list();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Customer customer = new Customer();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getCustomerByIdQuery = new StringBuilder("FROM Customer c");
			getCustomerByIdQuery.append(" WHERE c.isDeleted = :isDeleted");
			getCustomerByIdQuery.append(" AND c.pkCustomerId = :pkCustomerId");
			query = session.createQuery(getCustomerByIdQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkCustomerId", customerId);
			customer = (Customer) query.uniqueResult();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return customer;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
