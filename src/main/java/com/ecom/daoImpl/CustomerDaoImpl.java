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
 * @version 0.0.1
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
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
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
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
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
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
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
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
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
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
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
	public Integer updateCustomer(Integer customerId, Customer customerNewValues) {
		Customer customer = new Customer();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			StringBuilder getCustomerToUpdateQuery = new StringBuilder("FROM Customer c");
			getCustomerToUpdateQuery.append(" WHERE c.isDeleted = :isDeleted");
			getCustomerToUpdateQuery.append(" AND c.pkCustomerId = :pkCustomerId");
			query = session.createQuery(getCustomerToUpdateQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkCustomerId", customerId);
			customer = (Customer) query.uniqueResult();
			if (customerNewValues.getCustomerName() != null)
				customer.setCustomerName(customerNewValues.getCustomerName());
			if (customerNewValues.getContactName() != null)
				customer.setContactName(customerNewValues.getCustomerName());
			if (customerNewValues.getAddress() != null)
				customer.setAddress(customerNewValues.getAddress());
			if (customerNewValues.getCity() != null)
				customer.setCity(customerNewValues.getCity());
			if (customerNewValues.getPostalCode() != null)
				customer.setPostalCode(customerNewValues.getPostalCode());
			if (customerNewValues.getCountry() != null)
				customer.setCountry(customerNewValues.getCountry());
			session.update(customer);
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
	public Integer deleteCustomerById(Integer customerId) {
		Customer customer = new Customer();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			StringBuilder getCustomerToDeleteQuery = new StringBuilder("FROM Customer c");
			getCustomerToDeleteQuery.append(" WHERE c.isDeleted = :isDeleted");
			getCustomerToDeleteQuery.append(" AND c.pkCustomerId = :pkCustomerId");
			query = session.createQuery(getCustomerToDeleteQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkCustomerId", customerId);
			customer = (Customer) query.uniqueResult();
			customer.setIsDeleted(1);
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
	public Integer deleteCustomersByCountries(List<String> countries) {
		List<Customer> customers = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			StringBuilder getCustomerToDeleteByCountriesQuery = new StringBuilder("FROM Customer c");
			getCustomerToDeleteByCountriesQuery.append(" WHERE c.isDeleted = :isDeleted");
			getCustomerToDeleteByCountriesQuery.append(" AND c.country IN (:country)");
			query = session.createQuery(getCustomerToDeleteByCountriesQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameterList("country", countries);
			customers = query.list();
			for (Customer customer : customers) {
				customer.setIsDeleted(1);
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
