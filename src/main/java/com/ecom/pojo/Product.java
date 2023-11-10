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
 * Product Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_product_id")
	private Integer pkProductId;

	@Column(name = "product_name")
	private String productName;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_supplier_id", nullable = false)
	private Supplier supplier;

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "fk_category_id", nullable = false)
	private Category category;

	private String unit;
	private Double price;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkProductId() {
		return pkProductId;
	}

	public void setPkProductId(Integer pkProductId) {
		this.pkProductId = pkProductId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Product() {
		super();
	}

	public Product(Integer pkProductId, String productName, Supplier supplier, Category category, String unit,
			Double price, Integer isDeleted) {
		this.pkProductId = pkProductId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.unit = unit;
		this.price = price;
		this.isDeleted = isDeleted;
	}

}
