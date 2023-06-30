package com.cglia.student.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private String courseCode;

	@ManyToMany(mappedBy = "course")
	private List<Student> student = new ArrayList<>();

	public Course() {
		super();
	}

	public Course(int courseId, String courseName, String courseCode, List<Student> student) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCode = courseCode;

		this.student = student;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@JsonIgnoreProperties
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

}
