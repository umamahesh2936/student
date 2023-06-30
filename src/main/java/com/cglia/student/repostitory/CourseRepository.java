package com.cglia.student.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cglia.student.dto.Course;

@EnableJpaRepositories
public interface CourseRepository extends JpaRepository<Course, Integer> {
	List<Course> findByCourseNameContaining(String courseName);

	List<Course> findByCourseIdGreaterThan(int id);

	List<Course> findByCourseCodeContaining(String courseCode);

	List<Course> findAllByOrderByCourseCode();
}
