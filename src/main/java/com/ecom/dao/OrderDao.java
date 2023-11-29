package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public interface OrderDao {
	public List<Order> getAllOrders();

	public Order getOrderByOrderId(Integer orderId);

	public Order getOrderByCustomerId(Integer customerId);

	public Order getOrderByOrderDate(String orderDate);

	public Integer addNewOrder(Order order);

	public Integer addNewOrders(List<Order> order);

	public Integer updateOrderbyOrderId(Integer orderId, Order order);

	public Integer updateOrderByShipperId(Integer shipperId, Order order);

	public Integer deleteOrderByOrderId(Integer orderId);

	public Integer deleteOrderByEmployeeId(Integer employeeId);

	public Integer deleteOrderByCustomerId(Integer customerId);

	String getErrorMessage();
}
