package com.ecom.managerImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.dao.EmployeeDao;
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
		if (orderDetails.isEmpty()) {
			statusCode = 400;
			errorMessage = "OrderDetail entries not provided";
			return 0;
		}
		Integer result = orderDetailDao.insertOrderDetail(orderDetails);
		if (result == 0) {
			statusCode = 500;
			errorMessage = "Something went wrong";
		}
		return result;
	}

	@Override
	public Integer updateOrderDetailByOrderDetailId(Integer orderDetailId, OrderDetail orderDetail) {
		if (orderDetailId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid orderDetail ID";
		}
		if (orderDetail.getOrder().getPkOrderId() == null || orderDetail.getProduct().getPkProductId() == null
				|| orderDetail.getQuantity() <= 0) {
			statusCode = 400;
			errorMessage = "OrderDetail entries not provided";
		}
		return orderDetailDao.updateOrderDetailByOrderDetailId(orderDetailId, orderDetail);
	}

	@Override
	public Integer updateOrderDetailByProductId(Integer productId, OrderDetail orderDetail) {
		if (productId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid product ID";
		}
		if (orderDetail.getOrder().getPkOrderId() == null || orderDetail.getProduct().getPkProductId() == null
				|| orderDetail.getQuantity() <= 0) {
			statusCode = 400;
			errorMessage = "OrderDetail entries not provided";
		}
		return orderDetailDao.updateOrderDetailByProductId(productId, orderDetail);
	}

	@Override
	public Integer updateOrderDetailByOrderId(Integer orderId, OrderDetail orderDetail) {
		if (orderId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid order ID";
		}
		if (orderDetail.getOrder().getPkOrderId() == null || orderDetail.getProduct().getPkProductId() == null
				|| orderDetail.getQuantity() <= 0) {
			statusCode = 400;
			errorMessage = "OrderDetail entries not provided";
		}
		return orderDetailDao.updateOrderDetailByOrderId(orderId, orderDetail);
	}

	@Override
	public Integer deleteOrderDetail(Integer orderDetailId) {
		if (orderDetailId <= 0) {
			statusCode = 400;
			errorMessage = "Invalid OrderDetail ID";
		}
		Integer result = orderDetailDao.deleteOrderDetail(orderDetailId);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "OrderDetail with provided ID doesnot exist";
		}
		return result;
	}

	@Override
	public Integer deleteOrderDetails(List<Integer> orderDetailIds) {
		if (orderDetailIds.isEmpty()) {
			statusCode = 400;
			errorMessage = "Invalid OrderDetail IDs";
		}
		int result = orderDetailDao.deleteOrderDetails(orderDetailIds);
		if (result == 0) {
			statusCode = 404;
			errorMessage = "OrderDetails with provided IDs doesnot exist";
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
