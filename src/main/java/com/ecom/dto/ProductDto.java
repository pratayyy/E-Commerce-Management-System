package com.ecom.dto;

/**
 * Product's Dto Class
 * 
 * @author pratay.roy
 */
public class ProductDto {
	private Integer productId;
	private String productName;
	private SupplierDto supplier;
	private CategoryDto category;
	private String unit;
	private Double price;

	public Integer getProductId() {
		return productId;
	}

	public void setPkProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public SupplierDto getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
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

	public ProductDto() {
		super();
	}

	public ProductDto(Integer productId, String productName, SupplierDto supplier, CategoryDto category, String unit,
			Double price) {
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.unit = unit;
		this.price = price;
	}

	public void initialize() {
		supplier = new SupplierDto();
		category = new CategoryDto();
	}
}
