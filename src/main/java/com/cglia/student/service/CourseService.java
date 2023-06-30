package com.cglia.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.dao.CourseDao;
import com.cglia.student.dto.Course;
import com.cglia.student.dto.Student;

@Service
public class CourseService {
	@Autowired
	CourseDao courseDao;

	public String saveCourses(List<Course> list, int id) {
		return courseDao.saveCourses(list, id);
	}

	public List<Course> getByStudentId(int id) {
		return courseDao.getByStudentId(id);
	}

	public List<Course> getAll() {
		return courseDao.getAllCourses();
	}

	public List<Student> getStudentsByCourseId(int id) {
		return courseDao.getStudentByCourseId(id);
	}

	public List<Course> findByCourseNameContaining(String s) {
		return courseDao.findByCourseNameContaining(s);
	}

	public List<Course> findByCourseIdGreaterThan(int id) {
		return courseDao.findByCourseIdGreaterThan(id);
	}

	public List<Course> findByCourseCodeContaining(String s) {
		return courseDao.findByCourseCodeContaining(s);
	}

	public List<Course> findAllByOrderByCourseCode() {
		return courseDao.findAllByOrderByCourseCode();
	}

}
