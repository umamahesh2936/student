package com.cglia.student.controller;

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

import com.cglia.student.dto.Laptop;
import com.cglia.student.dto.Student;
import com.cglia.student.service.LaptopSerivce;

@RestController
@RequestMapping("/lap")
public class LaptopController {
	@Autowired
	LaptopSerivce laptopSerivce;

//working12
	@GetMapping("/laptop/student/{id}")
	public Laptop getByStudentId(@PathVariable int id) {
		return laptopSerivce.getByStudentId(id);
	}

//working12
	@PostMapping("/laptop/{id}")
	public String saveLaptop(@RequestBody Laptop laptop, @PathVariable int id) {
		return laptopSerivce.saveLaptop(laptop, id);
	}

//working12
	@DeleteMapping("/laptop/{id}")
	public String deleteLaptop(@PathVariable int id) {
		return laptopSerivce.deleteLaptop(id);
	}

//working12
	@PutMapping("/laptop/{id}")
	public String updateLaptop(@RequestBody Laptop laptop, @PathVariable int id) {
		return laptopSerivce.updateLaptop(laptop, id);
	}

//working12
	@GetMapping("/laptop/{id}")
	public Laptop getById(@PathVariable int id) {
		return laptopSerivce.getById(id);
	}

//working12
	@GetMapping("/laptop")
	public List<Laptop> getAll() {
		return laptopSerivce.getAll();
	}

//working12
	@GetMapping("/student/{id}")
	public Student getStudentByLaptopId(@PathVariable int id) {
		return laptopSerivce.getStudentByLaptopId(id);
	}

//working12
	@GetMapping("laptop/modellike/{model}")
	public List<Laptop> findByModelLike(@PathVariable String model) {
		return laptopSerivce.findByModelLike(model);
	}

//working
	@GetMapping("/laptop/laptopbrand/{laptopBrand}")
	public List<Laptop> findByLaptopBrandOrderByLaptopManufactureDateDesc(@PathVariable String laptopBrand) {
		return laptopSerivce.findByLaptopBrandOrderByLaptopManufactureDateDesc(laptopBrand);
	}

	@GetMapping("/laptop/orderbydesc")
	public List<Laptop> findAllByOrderBYLaptopId() {
		return laptopSerivce.findAllByOrderByDesc();
	}
}
