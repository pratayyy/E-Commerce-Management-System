package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public interface OrderDao {
	/**
	 * Method to get all orders
	 * 
	 * @return list of orders
	 */
	public List<Order> getAllOrders();

	/**
	 * Method to get order by Order Id
	 * 
	 * @param orderId
	 * @return order
	 */
	public Order getOrderByOrderId(Integer orderId);

	/**
	 * Method to get order(s) by customer Id
	 * 
	 * @param customerId
	 * @return list of orders
	 */
	public List<Order> getOrderByCustomerId(Integer customerId);

	/**
	 * Method to get order(s) by employee Id
	 * 
	 * @param employeeId
	 * @return list of orders
	 */
	public List<Order> getOrderByEmployeeId(Integer employeeId);

	/**
	 * Method to get order by order date
	 * 
	 * @param orderDate
	 * @return list of orders
	 */
	public List<Order> getOrderByOrderDate(String orderDate);

	/**
	 * Method to add a new order
	 * 
	 * @param order
	 * @return result
	 */
	public Integer addNewOrder(Order order);

	/**
	 * Method to add multiple orders
	 * 
	 * @param order
	 * @return result
	 */
	public Integer addNewOrders(List<Order> orders);

	/**
	 * Method to update order(s) by order Id
	 * 
	 * @param orderId
	 * @param order
	 * @return result
	 */
	public Integer updateOrderbyOrderId(Integer orderId, Order order);

	/**
	 * Method to update order(s) using shipper Id
	 * 
	 * @param shipperId
	 * @param order
	 * @return result
	 */
	public Integer updateOrderByShipperId(Integer shipperId, Order order);

	/**
	 * Method to delete order by order Id
	 * 
	 * @param orderId
	 * @return result
	 */
	public Integer deleteOrderByOrderId(Integer orderId);

	/**
	 * Method to delete order by employee Id
	 * 
	 * @param employeeId
	 * @return result
	 */
	public Integer deleteOrderByEmployeeId(Integer employeeId);

	/**
	 * Method to delete order by customer Id
	 * 
	 * @param customerId
	 * @return result
	 */
	public Integer deleteOrderByCustomerId(Integer customerId);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	String getErrorMessage();
}
