package com.ecom.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecom.dto.OrderDetailDto;
import com.ecom.manager.OrderDetailManager;
import com.ecom.pojo.OrderDetail;

/**
 * @author pratay.roy
 */
public class OrderDetailAction {
	private Integer orderDetailId;

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	private List<Integer> orderDetailIds;

	public List<Integer> getOrderDetailIds() {
		return orderDetailIds;
	}

	public void setOrderDetailIds(List<Integer> orderDetailIds) {
		this.orderDetailIds = orderDetailIds;
	}

	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	private OrderDetail orderDetail;

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	private Map<String, Object> root;

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	private HttpServletResponse response;

	private OrderDetailManager orderDetailManager;

	public OrderDetailManager getOrderDetailManager() {
		return orderDetailManager;
	}

	public void setOrderDetailManager(OrderDetailManager orderDetailManager) {
		this.orderDetailManager = orderDetailManager;
	}

	/**
	 * Constructor to get beans and response body initializations
	 */
	public OrderDetailAction() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			orderDetailManager = (OrderDetailManager) context.getBean("orderDetailManager");
		} catch (Exception e) {
			e.printStackTrace();
		}
		root = new HashMap<String, Object>();
		response = ServletActionContext.getResponse();
	}

	/**
	 * Method to set response when receiving a list of orderDetails as output
	 * 
	 * @param orderDetails
	 */
	public void handleResponse(List<OrderDetailDto> orderDetails) {
		if (orderDetails == null) {
			root.put("message", orderDetailManager.getErrorMessage());
			response.setStatus(orderDetailManager.getStatusCode());
		} else {
			root.put("orderDetails", orderDetails);
		}
	}

	/**
	 * Method to set response when receiving a single orderDetail as output
	 * 
	 * @param orderDetail
	 */
	public void handleResponse(OrderDetailDto orderDetail) {
		if (orderDetail == null) {
			root.put("message", orderDetailManager.getErrorMessage());
			response.setStatus(orderDetailManager.getStatusCode());
		} else {
			root.put("orderDetail", orderDetail);
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
			root.put("message", orderDetailManager.getErrorMessage());
			response.setStatus(orderDetailManager.getStatusCode());
		}
	}

	/**
	 * Method to get orderDetail by orderDetailId
	 * 
	 * @return success
	 */
	public String readById() {
		OrderDetailDto orderDetail = orderDetailManager.getOrderDetailsById(orderDetailId);
		handleResponse(orderDetail);
		return "success";
	}

	/**
	 * Method to get orderDetail(s) by orderDetailId(s)
	 * 
	 * @return success
	 */
	public String readByIds() {
		List<OrderDetailDto> orderDetails = orderDetailManager.getOrderDetailsByIds(orderDetailIds);
		handleResponse(orderDetails);
		return "success";
	}

	/**
	 * Method to insert new orderDetail
	 * 
	 * @return success
	 */
	public String insert() {
		Integer result = orderDetailManager.insertOrderDetail(orderDetails);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update details using orderDetailId
	 * 
	 * @return success
	 */
	public String updateByDetailId() {
		Integer result = orderDetailManager.updateOrderDetailByOrderDetailId(orderDetailId, orderDetail);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update details using ProductId
	 * 
	 * @return success
	 */
	public String updateByProductId() {
		Integer result = orderDetailManager.updateOrderDetailByProductId(orderDetailId, orderDetail);
		handleResponse(result);
		return "success";
	}

	/**
	 * Method to update details using OrderId
	 * 
	 * @return success
	 */
	public String updateByOrderId() {
		Integer result = orderDetailManager.updateOrderDetailByOrderId(orderDetailId, orderDetail);
		handleResponse(result);
		return "success";
	}

}
