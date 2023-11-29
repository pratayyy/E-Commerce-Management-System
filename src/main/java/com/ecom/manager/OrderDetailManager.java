package com.ecom.manager;

import com.ecom.dto.OrderDetailDto;

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
