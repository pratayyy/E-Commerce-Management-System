package com.ecom.dto;

/**
 * OrderDetail's Dto Class
 * 
 * @author pratay.roy
 */

public class OrderDetailDto {
	private Integer orderDetailId;
	private OrderDto order;
	private ProductDto product;
	private Integer quantity;

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderDetailDto() {
		super();
	}

	public OrderDetailDto(Integer orderDetailId, OrderDto order, ProductDto product, Integer quantity) {
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public void initialize() {
		order = new OrderDto();
		product = new ProductDto();
	}
}
