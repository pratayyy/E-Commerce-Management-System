package com.ecom.dto;

/**
 * Product's Dto Class
 * 
 * @author pratay.roy
 */
public class ProductDto {
	private Integer pkProductId;
	private String productName;
	private SupplierDto supplier;
	private CategoryDto category;
	private String unit;
	private Double price;

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

	public ProductDto(Integer pkProductId, String productName, SupplierDto supplier, CategoryDto category, String unit,
			Double price) {
		this.pkProductId = pkProductId;
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
