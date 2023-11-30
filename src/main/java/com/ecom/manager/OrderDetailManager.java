package com.ecom.manager;

import java.util.List;

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
	 * Method to get orderDetail(s) by orderDetailId(s)
	 * 
	 * @param orderDetailIds
	 * @return list of orderDetailDtos
	 */
	public List<OrderDetailDto> getOrderDetailsByIds(List<Integer> orderDetailIds);

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
