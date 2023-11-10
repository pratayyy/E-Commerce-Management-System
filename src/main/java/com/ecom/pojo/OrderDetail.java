package com.ecom.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "orderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_order_detail_id")
	private Integer pkOrderDetailId;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_order_id", nullable = false)
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_product_id", nullable = false)
	private Product product;

	private Integer quantity;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkOrderDetailId() {
		return pkOrderDetailId;
	}

	public void setPkOrderDetailId(Integer pkOrderDetailId) {
		this.pkOrderDetailId = pkOrderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer pkOrderDetailId, Order order, Product product, Integer quantity, Integer isDeleted) {
		this.pkOrderDetailId = pkOrderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.isDeleted = isDeleted;
	}

}
