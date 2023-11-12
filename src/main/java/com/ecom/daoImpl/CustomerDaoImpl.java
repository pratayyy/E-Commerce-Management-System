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
	private Integer result = 0;

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
	public List<Customer> getAllCustomersByCountries(List<String> countries) {
		List<Customer> customers = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getAllCustomersByCountriesQuery = new StringBuilder("FROM Customer c");
			getAllCustomersByCountriesQuery.append(" WHERE c.isDeleted = :isDeleted");
			getAllCustomersByCountriesQuery.append(" AND c.country IN (:country)");
			query = session.createQuery(getAllCustomersByCountriesQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameterList("country", countries);
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
	public Integer addNewCustomer(Customer customer) {
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			customer.setIsDeleted(-1);
			session.save(customer);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = 0;
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer addNewCustomers(List<Customer> customers) {
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			for (Customer customer : customers) {
				customer.setIsDeleted(-1);
				session.save(customer);
				result += 1;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = 0;
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
