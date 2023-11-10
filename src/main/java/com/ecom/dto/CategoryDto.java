package com.ecom.dto;

/**
 * Category's Dto Class
 * 
 * @author pratay.roy
 */

public class CategoryDto {
	private Integer pkCategoryId;
	private String categoryName;
	private String description;

	public Integer getPkCategoryId() {
		return pkCategoryId;
	}

	public void setPkCategoryId(Integer pkCategoryId) {
		this.pkCategoryId = pkCategoryId;
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

	public CategoryDto(Integer pkCategoryId, String categoryName, String description) {
		this.pkCategoryId = pkCategoryId;
		this.categoryName = categoryName;
		this.description = description;
	}

}
