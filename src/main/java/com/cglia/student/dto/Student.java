
package com.cglia.student.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student_details")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;
	private Date birthDate;
	private Integer age;
	private Integer status;
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Laptop laptop;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> address = new ArrayList<>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> course = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(Integer studentId, String studentName, Date birthDate, Integer age, Integer status, Laptop laptop,
			List<Address> address, List<Course> course) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.birthDate = birthDate;
		this.age = age;
		this.status = status;
		this.laptop = laptop;
		this.address = address;
		this.course = course;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonIgnoreProperties("student")
	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@JsonIgnoreProperties("student")
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@JsonIgnoreProperties("student")
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

}
