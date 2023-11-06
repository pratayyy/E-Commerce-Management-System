package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecom.dao.CustomerDao;
import com.ecom.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	private Configuration cfg;
	private String errorMessage;

	public CustomerDaoImpl() {
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = null;
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			String hql = "FROM Customer c WHERE c.isDeleted = :isDeleted";
			query = session.createQuery(hql);
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
	public String getErrorMessage() {
		return errorMessage;
	}

}
