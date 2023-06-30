
package com.cglia.student.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String village;
	private String city;
	private String state;
	private Long zipCode;
	private Integer status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	public Address() {
		super();
	}

	public Address(int addressId, String village, String city, String state, Long zipCode, Integer status,
			Student student) {
		super();
		this.addressId = addressId;
		this.village = village;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
		this.student = student;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	@JsonIgnoreProperties
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
