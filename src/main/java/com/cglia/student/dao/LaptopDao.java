package com.cglia.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cglia.student.dto.Laptop;
import com.cglia.student.dto.Student;
import com.cglia.student.repostitory.LaptopRepository;
import com.cglia.student.repostitory.StudentRepository;
import com.cglia.student.validation.StudentValidation;

@Repository
public class LaptopDao {
	@Autowired
	LaptopRepository laptopRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentValidation laptopValidation;

	public Laptop findByStudentId(int id) {
		return studentRepository.getById(id).getLaptop();
	}

//working
	@Transactional
	public String saveLaptop(Laptop laptop, int id) {
		try {
			Student student = studentRepository.findById(id).get();
			if (laptop != null && student.getStatus() == 1 && student.getLaptop() == null) {
				laptop.setStudent(student);
				laptop.setStatus(1);
				laptopRepository.save(laptop);
				return "Successfully Added Laptop";
			}
		} catch (Exception e) {
			return "Details not Found";
		}
		return null;

	}

	public String updateLaptop(Laptop laptop, int id) {
		try {
			Student student = studentRepository.findById(id).get();
			if (laptop != null && student != null && student.getLaptop() != null) {
				laptop.setStudent(student);
				laptopRepository.save(laptop);
				return "Successfully Updated Laptop";
			}
		} catch (Exception e) {
			return "Details not Found";
		}
		return null;
	}

//working
	@Transactional
	public String deleteLaptop(int id) {
		Student student = getStudentByLaptopId(id);
		Laptop laptop = laptopRepository.getById(id);
		if (laptop != null && student == null) {
			laptop.setStatus(0);
			laptopRepository.save(laptop);
			return "Deleted Successfully";
		}
		return "Can not Delete the laptop wihtout Deleting the Student";
	}

//working
	public Laptop getById(int id) {
		Optional<Laptop> optional = laptopRepository.findById(id);
		if (!optional.isEmpty() && optional.get().getStatus() == 1) {
			return optional.get();
		}
		return null;
	}

//working
	public List<Laptop> getAll() {
		List<Laptop> list = laptopRepository.findAll();
		return laptopValidation.laptopValidate(list);
	}

	@Transactional
	public Student getStudentByLaptopId(int id) {
		try {
			Laptop laptop = getById(id);
			if (laptop != null)
				return laptop.getStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Laptop> findByModelNoLike(String model) {
		List<Laptop> list = laptopRepository.findByModelNoLike(model);
		return laptopValidation.laptopValidate(list);
	}

	public List<Laptop> findByLaptopBrandOrderByLaptopManufactureDateDesc(String laptopBrand) {
		List<Laptop> list = laptopRepository.findByLaptopBrandOrderByLaptopManufactureDateDesc(laptopBrand);
		return laptopValidation.laptopValidate(list);
	}

	public List<Laptop> findAllLaptopAndOrderByIdDesc() {
		List<Laptop> list = laptopRepository.findAllByOrderByLaptopIdDesc();
		return laptopValidation.laptopValidate(list);
	}

}
