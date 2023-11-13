package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecom.dao.EmployeeDao;
import com.ecom.pojo.Employee;

/**
 * @author pratay.roy
 */
public class EmployeeDaoImpl implements EmployeeDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	private Configuration configuration;
	private String errorMessage;
	private Integer result = 0;

	public EmployeeDaoImpl() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getAllEmployeesQuery = new StringBuilder("FROM Employee e");
			getAllEmployeesQuery.append(" WHERE e.isDeleted = :isDeleted");
			query = session.createQuery(getAllEmployeesQuery.toString());
			query.setParameter("isDeleted", -1);
			employees = query.list();
			transaction.commit();
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
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = new Employee();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getEmployeeByIdQuery = new StringBuilder("FROM Employee e");
			getEmployeeByIdQuery.append(" WHERE e.isDeleted = :isDeleted");
			getEmployeeByIdQuery.append(" AND e.pkEmployeeId = :pkEmployeeId");
			query = session.createQuery(getEmployeeByIdQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkEmployeeId", employeeId);
			employee = (Employee) query.uniqueResult();
			transaction.commit();
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
		return employee;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
