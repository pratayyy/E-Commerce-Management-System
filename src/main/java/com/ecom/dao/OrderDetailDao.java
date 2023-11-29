package com.ecom.dao;

import java.util.List;

import com.ecom.pojo.OrderDetail;

/**
 * @author pratay.roy
 */
public interface OrderDetailDao {
	/**
	 * Method to get orderDetail by orderDetailId
	 * 
	 * @param orderDetailId
	 * @return orderDetail
	 */
	public OrderDetail getOrderDetailsById(Integer orderDetailId);

	/**
	 * Method to get orderDetail(s) by orderDetailId(s)
	 * 
	 * @param orderDetailIds
	 * @return List of orderDetails
	 */
	public List<OrderDetail> getOrderDetailsByIds(List<Integer> orderDetailIds);

	/**
	 * Method to insert orderDetail
	 * 
	 * @param orderDetails
	 * @return result
	 */
	public Integer insertOrderDetail(List<OrderDetail> orderDetails);

	/**
	 * Method to update orderDetail by orderDetailId
	 * 
	 * @param orderDetailId
	 * @param orderDetail
	 * @return result
	 */
	public Integer updateOrderDetailByOrderDetailId(Integer orderDetailId, OrderDetail orderDetail);

	/**
	 * Method to update orderDetail by productId
	 * 
	 * @param productId
	 * @param orderDetail
	 * @return result
	 */
	public Integer updateOrderDetailByProductId(Integer productId, OrderDetail orderDetail);

	/**
	 * Method to update orderDetail by orderId
	 * 
	 * @param orderId
	 * @param orderDetail
	 * @return result
	 */
	public Integer updateOrderDetailByOrderId(Integer orderId, OrderDetail orderDetail);

	/**
	 * Method to delete orderDetail by orderDetailId
	 * 
	 * @param orderDetailId
	 * @return result
	 */
	public Integer deleteOrderDetail(Integer orderDetailId);

	/**
	 * Method to delete orderDetail(s) by orderDetailId(s)
	 * 
	 * @param orderDetailIds
	 * @return return
	 */
	public Integer deleteOrderDetails(List<Integer> orderDetailIds);

	/**
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	String getErrorMessage();

}
