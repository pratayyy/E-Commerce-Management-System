package com.ecom.dto;

import java.sql.Blob;
import java.sql.Date;

/**
 * Employee's Dto Class
 * 
 * @author pratay.roy
 */

public class EmployeeDto {
	private Integer employeeId;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private Blob photo;
	private String notes;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setPkEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Integer employeeId, String lastName, String firstName, Date birthDate, Blob photo,
			String notes) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.photo = photo;
		this.notes = notes;
	}

}
