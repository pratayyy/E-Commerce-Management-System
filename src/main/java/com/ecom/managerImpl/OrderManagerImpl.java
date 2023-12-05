package com.ecom.managerImpl;

import java.util.List;

import com.ecom.dao.OrderDao;
import com.ecom.dto.OrderDto;
import com.ecom.manager.OrderManager;
import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public class OrderManagerImpl implements OrderManager {
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	private String errorMessage;
	private Integer statusCode;

	@Override
	public List<OrderDto> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto getOrderByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrdersByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrdersByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrdersByOrderDate(String orderDate) {
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
		String daoErrorMessage = orderDao.getErrorMessage();
		return daoErrorMessage != null ? daoErrorMessage : errorMessage;
	}

	@Override
	public Integer getStatusCode() {
		String daoErrorMessage = orderDao.getErrorMessage();
		return daoErrorMessage != null ? 500 : statusCode;
	}

}
