package com.ecom.pojo;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee Entity
 * 
 * @author pratay.roy
 */

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_employee_id")
	private Integer pkEmployeeId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "birth_date")
	private Date birthDate;

	private Blob photo;
	private String notes;

	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Integer getPkEmployeeId() {
		return pkEmployeeId;
	}

	public void setPkEmployeeId(Integer pkEmployeeId) {
		this.pkEmployeeId = pkEmployeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Employee() {
		super();
	}

	public Employee(Integer pkEmployeeId, String lastName, String firstName, Date birthDate, Blob photo, String notes,
			Integer isDeleted) {
		this.pkEmployeeId = pkEmployeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.photo = photo;
		this.notes = notes;
		this.isDeleted = isDeleted;
	}

}
