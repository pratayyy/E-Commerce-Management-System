package com.ecom.manager;

import java.sql.Date;
import java.util.List;

import com.ecom.dto.OrderDto;
import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 * @version 0.0.1
 */
public interface OrderManager {
	/**
	 * Method to get all orders
	 * 
	 * @return list of orders
	 */
	public List<OrderDto> getAllOrders();

	/**
	 * Method to get order by Order Id
	 * 
	 * @param orderId
	 * @return order
	 */
	public OrderDto getOrderByOrderId(Integer orderId);

	/**
	 * Method to get order(s) by customer Id
	 * 
	 * @param customerId
	 * @return list of orders
	 */
	public List<OrderDto> getOrdersByCustomerId(Integer customerId);

	/**
	 * Method to get order(s) by employee Id
	 * 
	 * @param employeeId
	 * @return list of orders
	 */
	public List<OrderDto> getOrdersByEmployeeId(Integer employeeId);

	/**
	 * Method to get order by order date
	 * 
	 * @param orderDate
	 * @return list of orders
	 */
	public List<OrderDto> getOrdersByOrderDate(Date orderDate);

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
	public Integer updateOrderByOrderId(Integer orderId, Order order);

	/**
	 * Method to update order(s) using shipper Id
	 * 
	 * @param shipperId
	 * @param order
	 * @return result
	 */
	public Integer updateOrdersByShipperId(Integer shipperId, Order order);

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
	public Integer deleteOrdersByEmployeeId(Integer employeeId);

	/**
	 * Method to delete order by customer Id
	 * 
	 * @param customerId
	 * @return result
	 */
	public Integer deleteOrdersByCustomerId(Integer customerId);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	String getErrorMessage();

	/**
	 * Method to get response body
	 * 
	 * @return statusCode
	 */
	public Integer getStatusCode();
}
