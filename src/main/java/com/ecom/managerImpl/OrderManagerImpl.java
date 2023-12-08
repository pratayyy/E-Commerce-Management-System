package com.ecom.managerImpl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.OrderDao;
import com.ecom.dto.OrderDto;
import com.ecom.manager.OrderManager;
import com.ecom.pojo.Order;
import com.ecom.util.Mapper;

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
		List<Order> orders = orderDao.getAllOrders();
		if (orders.isEmpty()) {
			statusCode = 404;
			errorMessage = "Orders doesnot exist";
		}
		return orders.isEmpty() ? null
				: orders.stream().map(order -> Mapper.orderDtoMpper(order)).collect(Collectors.toList());
	}

	@Override
	public OrderDto getOrderByOrderId(Integer orderId) {
		if (orderId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Order Id";
			return null;
		}
		Order order = orderDao.getOrderByOrderId(orderId);
		if (order == null) {
			statusCode = 404;
			errorMessage = "Order with given Order Id doesnot exist";
		}
		return order == null ? null : Mapper.orderDtoMpper(order);
	}

	@Override
	public List<OrderDto> getOrdersByCustomerId(Integer customerId) {
		if (customerId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Customer Id";
			return null;
		}
		List<Order> orders = orderDao.getOrdersByCustomerId(customerId);
		if (orders.isEmpty()) {
			statusCode = 404;
			errorMessage = "Orders with given Customer Id doesnot exist";
		}
		return orders.isEmpty() ? null
				: orders.stream().map(order -> Mapper.orderDtoMpper(order)).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getOrdersByEmployeeId(Integer employeeId) {
		if (employeeId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Employee Id";
			return null;
		}
		List<Order> orders = orderDao.getOrdersByEmployeeId(employeeId);
		if (orders.isEmpty()) {
			statusCode = 404;
			errorMessage = "Orders with given Employee Id doesnot exist";
		}
		return orders.isEmpty() ? null
				: orders.stream().map(order -> Mapper.orderDtoMpper(order)).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getOrdersByOrderDate(Date orderDate) {
		if (orderDate == null) {
			statusCode = 400;
			errorMessage = "Invalid Order Date";
			return null;
		}
		List<Order> orders = orderDao.getOrdersByOrderDate(orderDate);
		if (orders.isEmpty()) {
			statusCode = 404;
			errorMessage = "Orders with given Order Date doesnot exist";
		}
		return orders.isEmpty() ? null
				: orders.stream().map(order -> Mapper.orderDtoMpper(order)).collect(Collectors.toList());
	}

	@Override
	public Integer addNewOrder(Order order) {
		if (order == null) {
			statusCode = 400;
			errorMessage = "Order details empty";
			return null;
		}
		Integer result = orderDao.addNewOrder(order);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "Something went wrong";
		}
		return result;
	}

	@Override
	public Integer addNewOrders(List<Order> orders) {
		if (orders.isEmpty()) {
			statusCode = 400;
			errorMessage = "Orders list empty";
			return null;
		}
		Integer result = orderDao.addNewOrders(orders);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "Something went wrong";
		}
		return result;
	}

	@Override
	public Integer updateOrderByOrderId(Integer orderId, Order order) {
		if (orderId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Order Id";
			return null;
		}
		if (order == null) {
			statusCode = 400;
			errorMessage = "Order details empty";
			return null;
		}
		if (orderDao.getOrderByOrderId(orderId) == null) {
			statusCode = 404;
			errorMessage = "Order with given Order Id doesnot exist";
		}
		Integer result = orderDao.updateOrderByOrderId(orderId, order);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "Something went wrong while updating";
		}
		return result;
	}

	@Override
	public Integer updateOrdersByShipperId(Integer shipperId, Order order) {
		if (shipperId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid Order Id";
			return null;
		}
		if (order == null) {
			statusCode = 400;
			errorMessage = "Order details empty";
			return null;
		}
		Integer result = orderDao.updateOrdersByShipperId(shipperId, order);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "Something went wrong while updating";
		}
		return result;
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
