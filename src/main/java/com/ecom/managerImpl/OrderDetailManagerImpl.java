package com.ecom.managerImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.OrderDetailDao;
import com.ecom.dto.OrderDetailDto;
import com.ecom.manager.OrderDetailManager;
import com.ecom.pojo.OrderDetail;
import com.ecom.util.Mapper;

public class OrderDetailManagerImpl implements OrderDetailManager {
	private OrderDetailDao orderDetailDao;

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	private String errorMessage;
	private Integer statusCode;

	@Override
	public OrderDetailDto getOrderDetailsById(Integer orderDetailId) {
		if (orderDetailId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid OrderDetail ID";
			return null;
		}
		OrderDetail orderDetail = orderDetailDao.getOrderDetailsById(orderDetailId);
		if (orderDetail == null) {
			statusCode = 404;
			errorMessage = "OrderDetail with provided OrderDetail ID doesnot exist";
		}
		return orderDetail == null ? null : Mapper.orderDetailDtoMapper(orderDetail);
	}

	@Override
	public List<OrderDetailDto> getOrderDetailsByIds(List<Integer> orderDetailIds) {
		if (orderDetailIds == null || orderDetailIds.isEmpty()) {
			statusCode = 400;
			errorMessage = "OrderDetailIds list is empty";
			return null;
		}
		List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailsByIds(orderDetailIds);
		if (orderDetails.isEmpty()) {
			statusCode = 404;
			errorMessage = "OrderDetails doesnot exist for these orderDetailIds";
		}
		return orderDetails.isEmpty() ? null
				: orderDetails.stream().map(orderDetail -> Mapper.orderDetailDtoMapper(orderDetail))
						.collect(Collectors.toList());
	}

	@Override
	public Integer insertOrderDetail(List<OrderDetail> orderDetails) {
		Integer result = orderDetailDao.insertOrderDetail(orderDetails);
		if (result == 0) {
			statusCode = 500;
			errorMessage = "Something went wrong";
		}
		return result;
	}

	@Override
	public String getErrorMessage() {
		String daoErrorMessage = orderDetailDao.getErrorMessage();
		return daoErrorMessage != null ? daoErrorMessage : errorMessage;
	}

	@Override
	public Integer getStatusCode() {
		String daoErrorMessage = orderDetailDao.getErrorMessage();
		return daoErrorMessage != null ? 500 : statusCode;
	}

}
