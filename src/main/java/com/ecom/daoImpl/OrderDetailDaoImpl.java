package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecom.dao.OrderDetailDao;
import com.ecom.pojo.OrderDetail;

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
			getOrderDetailsByIdQuery.append(" WHERE od.pkOrderDetailId = :pkOrderDetailId");
			query = session.createQuery(getOrderDetailsByIdQuery.toString());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertOrderDetail(List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateOrderDetailByOrderDetailId(Integer orderDetailId, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateOrderDetailByProductId(Integer productId, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateOrderDetailByOrderId(Integer orderId, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrderDetail(Integer orderDetailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrderDetails(List<Integer> orderDetailIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
