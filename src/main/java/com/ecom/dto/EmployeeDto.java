package com.ecom.dto;

import java.sql.Blob;
import java.sql.Date;

/**
 * Employee's Dto Class
 * 
 * @author pratay.roy
 */

public class EmployeeDto {
	private Integer pkEmployeeId;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private Blob photo;
	private String notes;

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

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Integer pkEmployeeId, String lastName, String firstName, Date birthDate, Blob photo,
			String notes) {
		this.pkEmployeeId = pkEmployeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.photo = photo;
		this.notes = notes;
	}

}
