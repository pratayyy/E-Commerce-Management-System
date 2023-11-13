package com.ecom.dto;

/**
 * Category's Dto Class
 * 
 * @author pratay.roy
 */

public class CategoryDto {
	private Integer categoryId;
	private String categoryName;
	private String description;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDto() {
		super();
	}

	public CategoryDto(Integer categoryId, String categoryName, String description) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
	}

}
