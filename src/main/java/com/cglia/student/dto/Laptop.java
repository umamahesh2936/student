
package com.cglia.student.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "laptop")
public class Laptop implements Serializable {
	@Id
	private Integer laptopId;
	private String laptopBrand;
	private Date laptopManufactureDate;
	private String modelNo;
	private Integer status;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	public Laptop() {
		super();
	}

	public Laptop(Integer laptopId, String laptopBrand, Date laptopManufactureDate, String modelNo, Integer status,
			Student student) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.laptopManufactureDate = laptopManufactureDate;
		this.modelNo = modelNo;
		this.status = status;
		this.student = student;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public Date getLaptopManufactureDate() {
		return laptopManufactureDate;
	}

	public void setLaptopManufactureDate(Date laptopManufactureDate) {
		this.laptopManufactureDate = laptopManufactureDate;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	@JsonIgnoreProperties
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
