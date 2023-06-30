 	 	package com.cglia.student.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.student.dto.Student;
import com.cglia.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

	@PutMapping("/student")
	public String updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@GetMapping("/student/{id}")
	public Student getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/student")
	public List<Student> getAll() {
		return service.getAll();
	}

	@GetMapping("/student/birhtgreaterthan/{birthDate}")
	public List<Student> getBirthDateGreaterThan(@PathVariable Date birthDate) {
		return service.getStudentBirthGreateThan(birthDate);
	}

	@GetMapping("/student/namecontainting/{s}")
	public List<Student> getByNameContaining(@PathVariable String s) {
		return service.findByStudentNameContaining(s);
	}

	@GetMapping("/student/agelessthan/{age}")
	public List<Student> getByAgeLessThanAndOrederByDate(@PathVariable int age) {
		return service.findByAgeLessThanAndOrderByDOB(age);
	}

	@GetMapping("/student/date/{date1},{date2}")
	public List<Student> findByBirthDate(@PathVariable Date date1, @PathVariable Date date2) {
		return service.findByBirhtDateBetween(date1, date2);
	}
}
