package com.ecom.daoImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ecom.dao.OrderDao;
import com.ecom.pojo.Customer;
import com.ecom.pojo.Employee;
import com.ecom.pojo.Order;
import com.ecom.pojo.Shipper;

/**
 * @author pratay.roy
 * @version 0.0.1
 */
public class OrderDaoImpl implements OrderDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Configuration configuration;
	private String errorMessage;
	private Integer result = 0;

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
		Customer customer = new Customer();
		Employee employee = new Employee();
		Shipper shipper = new Shipper();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			if (order.getCustomer() != null)
				customer = (Customer) session.get(Customer.class, order.getCustomer().getPkCustomerId());
			if (order.getEmployee() != null)
				employee = (Employee) session.get(Employee.class, order.getEmployee().getPkEmployeeId());
			if (order.getShipper() != null)
				shipper = (Shipper) session.get(Shipper.class, order.getShipper().getPkShipperId());
			order.setCustomer(customer);
			order.setEmployee(employee);
			order.setShipper(shipper);
			order.setIsDeleted(-1);
			session.save(order);
			transaction.commit();
			result = 1;
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
		return result;
	}

	@Override
	public Integer addNewOrders(List<Order> orders) {
		Customer customer = new Customer();
		Employee employee = new Employee();
		Shipper shipper = new Shipper();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			for (Order order : orders) {
				if (order.getCustomer() != null)
					customer = (Customer) session.get(Customer.class, order.getCustomer().getPkCustomerId());
				if (order.getEmployee() != null)
					employee = (Employee) session.get(Employee.class, order.getEmployee().getPkEmployeeId());
				if (order.getShipper() != null)
					shipper = (Shipper) session.get(Shipper.class, order.getShipper().getPkShipperId());
				order.setCustomer(customer);
				order.setEmployee(employee);
				order.setShipper(shipper);
				order.setIsDeleted(-1);
				session.save(order);
				result += 1;
			}
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
		return result;
	}

	@Override
	public Integer updateOrderByOrderId(Integer orderId, Order order) {
		Order currentOrder = new Order();
		Customer customer = new Customer();
		Employee employee = new Employee();
		Shipper shipper = new Shipper();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			if (order.getCustomer() != null)
				customer = (Customer) session.get(Customer.class, order.getCustomer().getPkCustomerId());
			if (order.getEmployee() != null)
				employee = (Employee) session.get(Employee.class, order.getEmployee().getPkEmployeeId());
			if (order.getShipper() != null)
				shipper = (Shipper) session.get(Shipper.class, order.getShipper().getPkShipperId());
			currentOrder = (Order) session.createCriteria(Order.class).add(Restrictions.eq("isDeleted", -1))
					.uniqueResult();
			if (customer != null)
				currentOrder.setCustomer(customer);
			if (employee != null)
				currentOrder.setEmployee(employee);
			if (shipper != null)
				currentOrder.setShipper(shipper);
			if (order.getOrderDate() != null)
				currentOrder.setOrderDate(order.getOrderDate());
			session.update(currentOrder);
			transaction.commit();
			result = 1;
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
		return result;
	}

	@Override
	public Integer updateOrdersByShipperId(Integer shipperId, Order order) {
		List<Order> currentOrders = new ArrayList<Order>();
		Customer customer = new Customer();
		Employee employee = new Employee();
		Shipper shipper = new Shipper();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			if (order.getCustomer() != null)
				customer = (Customer) session.get(Customer.class, order.getCustomer().getPkCustomerId());
			if (order.getEmployee() != null)
				employee = (Employee) session.get(Employee.class, order.getEmployee().getPkEmployeeId());
			if (order.getShipper() != null)
				shipper = (Shipper) session.get(Shipper.class, order.getShipper().getPkShipperId());
			currentOrders = session.createCriteria(Order.class).add(Restrictions.eq("isDeleted", -1))
					.add(Restrictions.eq("shipper.id", shipperId)).list();
			for (Order currentOrder : currentOrders) {
				if (customer != null)
					currentOrder.setCustomer(customer);
				if (employee != null)
					currentOrder.setEmployee(employee);
				if (shipper != null)
					currentOrder.setShipper(shipper);
				if (order.getOrderDate() != null)
					currentOrder.setOrderDate(order.getOrderDate());
				session.update(currentOrder);
				result += 1;
			}
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
		return result;
	}

	@Override
	public Integer deleteOrderByOrderId(Integer orderId) {
		Order order = new Order();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			order = (Order) session.createCriteria(Order.class).add(Restrictions.eq("pkOrderId", orderId))
					.add(Restrictions.eq("isDeleted", -1)).uniqueResult();
			if (order != null)
				order.setIsDeleted(1);
			session.update(order);
			transaction.commit();
			result = 1;
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
		return result;
	}

	@Override
	public Integer deleteOrdersByEmployeeId(Integer employeeId) {
		List<Order> orders = new ArrayList<Order>();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("employee.id", employeeId))
					.add(Restrictions.eq("isDeleted", -1)).list();
			if (!orders.isEmpty()) {
				for (Order order : orders) {
					if (order != null)
						order.setIsDeleted(1);
					session.update(order);
					result += 1;
				}
			}
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
		return result;
	}

	@Override
	public Integer deleteOrdersByCustomerId(Integer customerId) {
		List<Order> orders = new ArrayList<Order>();
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createCriteria(Order.class).add(Restrictions.eq("customer.id", customerId))
					.add(Restrictions.eq("isDeleted", -1)).list();
			if (!orders.isEmpty()) {
				for (Order order : orders) {
					if (order != null)
						order.setIsDeleted(1);
					session.update(order);
					result += 1;
				}
			}
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
		return result;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
