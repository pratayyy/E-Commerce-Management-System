package com.ecom.daoImpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ecom.dao.OrderDao;
import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public class OrderDaoImpl implements OrderDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Configuration configuration;
	private String errorMessage;

	public OrderDaoImpl() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("isDeleted", -1)).list();
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
		return orders;
	}

	@Override
	public Order getOrderByOrderId(Integer orderId) {
		Order order = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			order = (Order) session.createCriteria(Order.class).add(Restrictions.eq("pkOrderId", orderId))
					.add(Restrictions.eq("isDeleted", -1)).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				sessionFactory.close();
			}
		}
		return order;
	}

	@Override
	public List<Order> getOrdersByCustomerId(Integer customerId) {
		List<Order> orders = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("customer.id", customerId))
					.add(Restrictions.eq("isDeleted", -1)).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				sessionFactory.close();
			}
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByEmployeeId(Integer employeeId) {
		List<Order> orders = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("employee.id", employeeId))
					.add(Restrictions.eq("isDeleted", -1)).list();
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
		return orders;
	}

	@Override
	public List<Order> getOrdersByOrderDate(Date orderDate) {
		List<Order> orders = null;
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("orderDate", orderDate))
					.add(Restrictions.eq("isDeleted", -1)).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			errorMessage = e.getMessage();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				sessionFactory.close();
			}
		}
		return orders;
	}

	@Override
	public Integer addNewOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addNewOrders(List<Order> order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateOrderByOrderId(Integer orderId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateOrdersByShipperId(Integer shipperId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrderByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrdersByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrdersByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
