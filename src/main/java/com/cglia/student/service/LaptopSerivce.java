package com.cglia.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.dao.LaptopDao;
import com.cglia.student.dto.Laptop;
import com.cglia.student.dto.Student;

@Service
public class LaptopSerivce {
	@Autowired
	LaptopDao dao;

	public Laptop getByStudentId(int id) {
		return dao.findByStudentId(id);
	}

	public List<Laptop> getAll() {
		return dao.getAll();
	}

	public String saveLaptop(Laptop laptop, int id) {
		return dao.saveLaptop(laptop, id);
	}

	public String deleteLaptop(int id) {
		return dao.deleteLaptop(id);
	}

	public Laptop getById(int id) {
		return dao.getById(id);
	}

	public Student getStudentByLaptopId(int id) {
		return dao.getStudentByLaptopId(id);
	}

	public String updateLaptop(Laptop laptop, int id) {
		Laptop laptop2 = getById(id);
		if (laptop2 != null) {
			Student student = getStudentByLaptopId(id);
			return dao.updateLaptop(laptop, student.getStudentId());
		}
		return "Invalid Id";
	}

	public List<Laptop> findByModelLike(String model) {
		return dao.findByModelNoLike(model);
	}

	public List<Laptop> findByLaptopBrandOrderByLaptopManufactureDateDesc(String laptopBrand) {
		return dao.findByLaptopBrandOrderByLaptopManufactureDateDesc(laptopBrand);
	}

	public List<Laptop> findAllByOrderByDesc() {
		return dao.findAllLaptopAndOrderByIdDesc();
	}
}
