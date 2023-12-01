package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ecom.dao.OrderDetailDao;
import com.ecom.pojo.Order;
import com.ecom.pojo.OrderDetail;
import com.ecom.pojo.Product;

/**
 * @author pratay.roy
 */
public class OrderDetailDaoImpl implements OrderDetailDao {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query query;
	private Configuration configuration;
	private String errorMessage;
	private Integer result = 0;

	public OrderDetailDaoImpl() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	}

	@Override
	public OrderDetail getOrderDetailsById(Integer orderDetailId) {
		OrderDetail orderDetail = new OrderDetail();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getOrderDetailsByIdQuery = new StringBuilder("FROM OrderDetail od");
			getOrderDetailsByIdQuery.append(" WHERE od.isDeleted = :isDeleted");
			getOrderDetailsByIdQuery.append(" AND od.pkOrderDetailId = :pkOrderDetailId");
			query = session.createQuery(getOrderDetailsByIdQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkOrderDetailId", orderDetailId);
			orderDetail = (OrderDetail) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getOrderDetailsByIds(List<Integer> orderDetailIds) {
		List<OrderDetail> orderDetails = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getOrderDetailsByIdsQuery = new StringBuilder("FROM OrderDetail od");
			getOrderDetailsByIdsQuery.append(" WHERE od.isDeleted = :isDeleted");
			getOrderDetailsByIdsQuery.append(" AND od.pkOrderDetailId IN (:pkOrderDetailId)");
			query = session.createQuery(getOrderDetailsByIdsQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameterList("pkOrderDetailId", orderDetailIds);
			orderDetails = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return orderDetails;
	}

	@Override
	public Integer insertOrderDetail(List<OrderDetail> orderDetails) {
		Order order = null;
		Product product = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				if (orderDetail.getOrder() == null || orderDetail.getProduct() == null
						|| orderDetail.getQuantity() >= 0) {
					continue;
				}
				StringBuilder getOrderQuery = new StringBuilder("FROM Order o");
				getOrderQuery.append(" WHERE o.pkOrderId = :pkOrderId");
				query = session.createQuery(getOrderQuery.toString());
				query.setParameter("pkOrderId", orderDetail.getOrder().getPkOrderId());
				order = (Order) query.uniqueResult();
				StringBuilder getProductQuery = new StringBuilder("FROM Product p");
				getProductQuery.append(" WHERE p.pkProductId = :pkProductId");
				query = session.createQuery(getProductQuery.toString());
				query.setParameter("pkProductId", orderDetail.getProduct().getPkProductId());
				product = (Product) query.uniqueResult();
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				session.save(orderDetail);
				result += 1;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer updateOrderDetailByOrderDetailId(Integer orderDetailId, OrderDetail orderDetail) {
		OrderDetail currentOrderDetail = null;
		Order order = null;
		Product product = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getCurrentOrderDetailQuery = new StringBuilder("FROM orderDetail od");
			getCurrentOrderDetailQuery.append(" WHERE od.pkOrderDetailId = :pkOrderDetailId");
			query = session.createQuery(getCurrentOrderDetailQuery.toString());
			query.setParameter("pkOrderDetailId", orderDetailId);
			currentOrderDetail = (OrderDetail) query.uniqueResult();
			if (orderDetail.getOrder() != null)
				order = (Order) session.get(Order.class, orderDetail.getOrder().getPkOrderId());
			if (orderDetail.getProduct() != null)
				product = (Product) session.get(Product.class, orderDetail.getProduct().getPkProductId());
			if (order != null)
				currentOrderDetail.setOrder(order);
			if (product != null)
				currentOrderDetail.setProduct(product);
			if (orderDetail.getQuantity() > 0)
				currentOrderDetail.setQuantity(orderDetail.getQuantity());
			session.update(currentOrderDetail);
			result = 1;
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer updateOrderDetailByProductId(Integer productId, OrderDetail orderDetail) {
		List<OrderDetail> currentOrderDetails = null;
		Order order = null;
		Product product = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getCurrentOrderDetailQuery = new StringBuilder("FROM orderDetail od");
			getCurrentOrderDetailQuery.append(" JOIN od.product p");
			getCurrentOrderDetailQuery.append(" WHERE p.pkProductId = :pkProductId");
			query = session.createQuery(getCurrentOrderDetailQuery.toString());
			query.setParameter("pkProductId", productId);
			currentOrderDetails = query.list();
			if (orderDetail.getOrder() != null)
				order = (Order) session.get(Order.class, orderDetail.getOrder().getPkOrderId());
			if (orderDetail.getProduct() != null)
				product = (Product) session.get(Product.class, orderDetail.getProduct().getPkProductId());
			for (OrderDetail detail : currentOrderDetails) {
				if (order != null)
					detail.setOrder(order);
				if (product != null)
					detail.setProduct(product);
				if (orderDetail.getQuantity() > 0)
					detail.setQuantity(orderDetail.getQuantity());
				result += 1;
			}
			session.update(currentOrderDetails);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer updateOrderDetailByOrderId(Integer orderId, OrderDetail orderDetail) {
		List<OrderDetail> currentOrderDetails = null;
		Order order = null;
		Product product = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder getCurrentOrderDetailQuery = new StringBuilder("FROM orderDetail od");
			getCurrentOrderDetailQuery.append(" JOIN od.order o");
			getCurrentOrderDetailQuery.append(" WHERE o.pkOrderId = :pkOrderId");
			query = session.createQuery(getCurrentOrderDetailQuery.toString());
			query.setParameter("pkOrderId", orderId);
			currentOrderDetails = query.list();
			if (orderDetail.getOrder() != null)
				order = (Order) session.get(Order.class, orderDetail.getOrder().getPkOrderId());
			if (orderDetail.getProduct() != null)
				product = (Product) session.get(Product.class, orderDetail.getProduct().getPkProductId());
			for (OrderDetail detail : currentOrderDetails) {
				if (order != null)
					detail.setOrder(order);
				if (product != null)
					detail.setProduct(product);
				if (orderDetail.getQuantity() > 0)
					detail.setQuantity(orderDetail.getQuantity());
				result += 1;
			}
			session.update(currentOrderDetails);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer deleteOrderDetail(Integer orderDetailId) {
		OrderDetail orderDetail = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder deleteOrderDetailQuery = new StringBuilder("FROM orderDetail od");
			deleteOrderDetailQuery.append(" WHERE od.isDeleted = :isDeleted");
			deleteOrderDetailQuery.append(" AND od.pkOrderDetailId = :pkOrderDetailId");
			query = session.createQuery(deleteOrderDetailQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameter("pkOrderDetailId", orderDetailId);
			orderDetail = (OrderDetail) query.uniqueResult();
			if (orderDetail != null) {
				orderDetail.setIsDeleted(1);
				result = 1;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		return result;
	}

	@Override
	public Integer deleteOrderDetails(List<Integer> orderDetailIds) {
		List<OrderDetail> orderDetails = null;
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			StringBuilder deleteOrderDetailsQuery = new StringBuilder("FROM orderDetail od");
			deleteOrderDetailsQuery.append(" WHERE od.isDeleted = :isDeleted");
			deleteOrderDetailsQuery.append(" AND od.pkOrderDetailId IN (:pkOrderDetaild)");
			query = session.createQuery(deleteOrderDetailsQuery.toString());
			query.setParameter("isDeleted", -1);
			query.setParameterList("pkOrderDetailId", orderDetailIds);
			orderDetails = query.list();
			for (OrderDetail orderDetail : orderDetails) {
				orderDetail.setIsDeleted(1);
				result += 1;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
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
