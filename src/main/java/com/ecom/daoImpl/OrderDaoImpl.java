package com.ecom.daoImpl;

import java.util.List;

import com.ecom.dao.OrderDao;
import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
