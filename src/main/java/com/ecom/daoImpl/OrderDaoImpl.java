package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

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
			orders = session.createCriteria(Order.class, "order").add(Restrictions.eq("order.isDeleted", -1)).list();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByOrderDate(String orderDate) {
		// TODO Auto-generated method stub
		return null;
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
