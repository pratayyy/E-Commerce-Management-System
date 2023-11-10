package com.ecom.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_category_id")
	private Integer pkCategoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "description")
	private String description;

	@Column(name = "is_deleted")
	private Integer isDeleted;

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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Category() {
		super();
	}

	public Category(Integer pkCategoryId, String categoryName, String description, Integer isDeleted) {
		this.pkCategoryId = pkCategoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.isDeleted = isDeleted;
	}

}
