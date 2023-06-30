package com.cglia.student.repostitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cglia.student.dto.Student;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Integer> {
	// get the students greater than the given date
	List<Student> findByBirthDateGreaterThan(Date date);

	List<Student> findByStudentNameContaining(String keyword);

	List<Student> findByAgeLessThanOrderByBirthDateAsc(int age);

	List<Student> findByLaptop_LaptopBrand(String laptopBrand);

	@Query("SELECT s FROM Student s WHERE s.birthDate BETWEEN :startDate AND :endDate")
	public List<Student> findByBirthDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
