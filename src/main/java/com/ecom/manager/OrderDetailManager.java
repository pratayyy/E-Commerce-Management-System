package com.ecom.manager;

import java.util.List;

import com.ecom.dto.OrderDetailDto;
import com.ecom.pojo.OrderDetail;

/**
 * @author pratay.roy
 */
public interface OrderDetailManager {
	/**
	 * Method to get orderDetail by orderDetailId
	 * 
	 * @param orderDetailId
	 * @return orderDetailDto
	 */
	public OrderDetailDto getOrderDetailsById(Integer orderDetailId);

	/**
	 * Method to get orderDetail(s) by orderDetailId(s)
	 * 
	 * @param orderDetailIds
	 * @return list of orderDetailDtos
	 */
	public List<OrderDetailDto> getOrderDetailsByIds(List<Integer> orderDetailIds);

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
	 * Method to get response body
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();

	/**
	 * Method to get response body
	 * 
	 * @return statusCode
	 */
	public Integer getStatusCode();
}
