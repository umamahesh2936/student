package com.cglia.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.student.dto.Course;
import com.cglia.student.dto.Student;
import com.cglia.student.service.CourseService;

@RestController
@RequestMapping("/cour")
public class CourseController {
	@Autowired
	CourseService service;

//working12
	@PostMapping("/course/{id}")
	public String saveCourses(@RequestBody List<Course> list, @PathVariable int id) {
		return service.saveCourses(list, id);
	}

//working12
	@GetMapping("/student/{id}")
	public List<Course> getByStudentId(@PathVariable int id) {
		return service.getByStudentId(id);
	}

//working12
	@GetMapping("/course")
	public List<Course> getAll() {
		return service.getAll();
	}

//working12
	@GetMapping("/course/student/{id}")
	public List<Student> getStudentsByCourseId(@PathVariable int id) {
		return service.getStudentsByCourseId(id);
	}

//working12
	@GetMapping("/course/coursename/{courseName}")
	public List<Course> findByCourseNameContaining(@PathVariable String courseName) {
		return service.findByCourseNameContaining(courseName);
	}

//working12
	@GetMapping("/course/courseid/{id}")
	public List<Course> findByCourseIdGreaterThan(@PathVariable int id) {
		return service.findByCourseIdGreaterThan(id);
	}

//working12
	@GetMapping("/course/coursecode/{courseCode}")
	public List<Course> findByCourseCodeContaining(@PathVariable String courseCode) {
		return service.findByCourseCodeContaining(courseCode);
	}

//working12
	@GetMapping("/course/orderbycoursecode")
	public List<Course> findAllByOrderByCourseCode() {
		return service.findAllByOrderByCourseCode();
	}

}
