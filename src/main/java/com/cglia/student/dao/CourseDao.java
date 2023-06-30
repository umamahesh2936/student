package com.cglia.student.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cglia.student.dto.Course;
import com.cglia.student.dto.Student;
import com.cglia.student.repostitory.CourseRepository;

@Repository
public class CourseDao {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentDao dao;

	public String saveCourses(List<Course> list, int id) {
		Student student = dao.getById(id);
		student.getCourse().addAll(list);
		dao.saveStudent(student);
		return "Succcessfully saved all the courses";
	}

	public List<Course> getByStudentId(int id) {
		Student student = dao.getById(id);

		if (student != null) {

			return student.getCourse();
		}
		return Collections.emptyList();
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public List<Student> getStudentByCourseId(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (!course.isEmpty()) {
			return course.get().getStudent();
		}
		return Collections.emptyList();
	}

	public List<Course> findByCourseNameContaining(String s) {
		return courseRepository.findByCourseNameContaining(s);
	}

	public List<Course> findByCourseIdGreaterThan(int id) {
		return courseRepository.findByCourseIdGreaterThan(id);
	}

	public List<Course> findByCourseCodeContaining(String s) {
		return courseRepository.findByCourseCodeContaining(s);
	}

	public List<Course> findAllByOrderByCourseCode() {
		return courseRepository.findAllByOrderByCourseCode();
	}

}
