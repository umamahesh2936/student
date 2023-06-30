package com.cglia.student.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cglia.student.dto.Address;
import com.cglia.student.dto.Laptop;
import com.cglia.student.dto.Student;
import com.cglia.student.repostitory.LaptopRepository;
import com.cglia.student.repostitory.StudentRepository;
import com.cglia.student.validation.StudentValidation;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;
	@Autowired
	AddressDao addressDao;
	@Autowired
	LaptopRepository laptopRepository;
	@Autowired
	StudentValidation studentValidation;

	@Transactional(rollbackFor = SQLException.class)
	public String saveStudent(Student student) {
		try {
			if (student != null && student.getLaptop() != null) {
				student.setStatus(1);
				Laptop laptop = student.getLaptop();
				laptop.setStatus(1);
				laptop.setStudent(student);
				student.setLaptop(laptop);
				List<Address> list = student.getAddress();
				if (!list.isEmpty()) {
					for (Address a : list) {
						a.setStatus(1);
						a.setStudent(student);
					}
				}
				student.setAddress(list);
				repository.save(student);
				return "Saved Successfully";
			}
		} catch (Exception exception) {
			return " Invalid Data";
		}
		return "";
	}

	@Transactional
	public String deleteStudent(int id) {
		try {
			Student student = repository.findById(id).get();
			if (student != null && student.getStatus() == 1) {
				Laptop laptop = student.getLaptop();
				laptop.setStatus(0);
				student.setLaptop(laptop);

				student.setStatus(0);
				List<Address> addresses = student.getAddress();
				List<Address> add = new ArrayList<>();
				for (Address a : addresses) {
					a.setStatus(0);
					add.add(a);
				}
				student.setAddress(add);
				repository.save(student);
				return "Deleted Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Invalid ID";
	}

	public Student getById(int id) {
		Optional<Student> optional = repository.findById(id);
		try {
			Student student = optional.get();
			if (student != null && student.getStatus() == 1) {
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> getAll() {
		List<Student> list = repository.findAll();
		return studentValidation.validateByStatus(list);
	}

	public List<Student> getBirthDataGreaterThan(Date date) {
		List<Student> list = repository.findByBirthDateGreaterThan(date);
		return studentValidation.validateByStatus(list);
	}

	public List<Student> findByNameContaining(String name) {
		List<Student> list = repository.findByStudentNameContaining(name);
		return studentValidation.validateByStatus(list);
	}

	public List<Student> findByAgeLessThanAndOrderByBirthDate(int age) {
		List<Student> list = repository.findByAgeLessThanOrderByBirthDateAsc(age);
		return studentValidation.validateByStatus(list);
	}

	public List<Student> findByStudentBetween(Date startDate, Date endDate) {
		List<Student> list = repository.findByBirthDateBetween(startDate, endDate);
		return studentValidation.validateByStatus(list);
	}
}
