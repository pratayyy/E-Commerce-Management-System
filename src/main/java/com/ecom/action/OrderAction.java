package com.ecom.action;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecom.dto.OrderDto;
import com.ecom.manager.OrderManager;
import com.ecom.pojo.Order;

/**
 * @author pratay.roy
 */
public class OrderAction {
	private Integer orderId;
	private Integer customerId;
	private Integer employeeId;
	private Integer shipperId;
	private Date orderDate;
	private Order order;
	private List<Order> orders;
	private Map<String, Object> root;
	private HttpServletResponse response;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	private OrderManager orderManager;

	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	/**
	 * Constructor to get beans and response body initializations
	 */
	public OrderAction() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			orderManager = (OrderManager) context.getBean("orderManager");
		} catch (Exception e) {
			e.printStackTrace();
		}
		root = new HashMap<String, Object>();
		response = ServletActionContext.getResponse();
	}

	/**
	 * Method to set response when receiving a list of orders as output
	 * 
	 * @param employees
	 */
	public void handleResponse(List<OrderDto> orders) {
		if (orders == null) {
			root.put("message", orderManager.getErrorMessage());
			response.setStatus(orderManager.getStatusCode());
		} else {
			root.put("orders", orders);
		}
	}

	/**
	 * Method to set response when receiving a single order as output
	 * 
	 * @param employee
	 */
	public void handleResponse(OrderDto order) {
		if (order == null) {
			root.put("message", orderManager.getErrorMessage());
			response.setStatus(orderManager.getStatusCode());
		} else {
			root.put("order", order);
		}
	}

	/**
	 * Method to set response when recieving result as output
	 * 
	 * @param result
	 */
	public void handleResponse(Integer result) {
		root.put("result", result);
		if (result == 0) {
			root.put("message", orderManager.getErrorMessage());
			response.setStatus(orderManager.getStatusCode());
		}
	}

	/**
	 * Method to get all orders
	 * 
	 * @return success
	 */
	public String read() {
		List<OrderDto> orders = orderManager.getAllOrders();
		handleResponse(orders);
		return "success";
	}

	/**
	 * Method to get order by Order Id
	 * 
	 * @return success
	 */
	public String readByOrderId() {
		OrderDto order = orderManager.getOrderByOrderId(orderId);
		handleResponse(order);
		return "success";
	}

	/**
	 * Method to get order(s) by customer Id
	 * 
	 * @return success
	 */
	public String readByCustomerId() {
		List<OrderDto> orders = orderManager.getOrdersByCustomerId(customerId);
		handleResponse(orders);
		return "success";
	}

	/**
	 * Method to get order(s) by employee Id
	 * 
	 * @return success
	 */
	public String readByEmployeeId() {
		List<OrderDto> orders = orderManager.getOrdersByEmployeeId(employeeId);
		handleResponse(orders);
		return "success";
	}

	/**
	 * Method to get order by order date
	 * 
	 * @return success
	 */
	public String readByOrderDate() {
		List<OrderDto> orders = orderManager.getOrdersByOrderDate(orderDate);
		handleResponse(orders);
		return "success";
	}

	/**
	 * Method to add a new order
	 * 
	 * @return success
	 */
	public String addOrder() {
		Integer result = orderManager.addNewOrder(order);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to add multiple orders
	 * 
	 * @return success
	 */
	public String addOrders() {
		Integer result = orderManager.addNewOrders(orders);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update order(s) by order Id
	 * 
	 * @return success
	 */
	public String updateByOrderId() {
		Integer result = orderManager.updateOrderByOrderId(orderId, order);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update order(s) using shipper Id
	 * 
	 * @return success
	 */
	public String updateByShipperId() {
		Integer result = orderManager.updateOrdersByShipperId(shipperId, order);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to delete order by order Id
	 * 
	 * @return success
	 */
	public String deleteByOrderId() {
		Integer result = orderManager.deleteOrderByOrderId(orderId);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to delete order by employee Id
	 * 
	 * @return success
	 */
	public String deleteByEmployeeId() {
		Integer result = orderManager.deleteOrdersByEmployeeId(employeeId);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to delete order by customer Id
	 * 
	 * @return success
	 */
	public String deleteByCustomerId() {
		Integer result = orderManager.deleteOrdersByCustomerId(customerId);
		handleResponse(result);
		return "success";
	}

}
