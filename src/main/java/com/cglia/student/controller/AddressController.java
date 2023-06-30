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

import com.cglia.student.dto.Address;
import com.cglia.student.dto.Student;
import com.cglia.student.service.AddressService;

@RestController
@RequestMapping("addr")
public class AddressController {

	@Autowired
	AddressService addressService;

//working12
	@GetMapping("/student/{id}")
	public List<Address> getByStudentId(@PathVariable int id) {
		return addressService.getByStudentId(id);
	}

//working12
	@GetMapping("/address/student/{id}")
	public Student getStudentbyAddressId(@PathVariable int id) {
		return addressService.getStudentByAddressId(id);
	}

	// working12
	@PostMapping("/address/{id}")
	public String saveAddress(@RequestBody Address address, @PathVariable int id) {
		return addressService.saveAddress(address, id);
	}

//working12
	@DeleteMapping("/address/{id}")
	public String deleteAddress(@PathVariable int id) {
		return addressService.deleteAddress(id);
	}

//working12
	@PutMapping("/address/{id}")
	public String updateAddress(@RequestBody Address address, @PathVariable int id) {
		return addressService.updateAddress(address, id);
	}

//working12
	@GetMapping("/address/{id}")
	public Address getById(@PathVariable int id) {
		return addressService.getById(id);
	}

//working12
	@GetMapping("/address")
	public List<Address> getAll() {
		return addressService.getAll();
	}

//working12
	@GetMapping("/address/village/{village}")
	public List<Address> findByVillage(@PathVariable String village) {
		return addressService.findByVillage(village);
	}

//working12
	@GetMapping("/address/zipcode/{zipCode}")
	public List<Address> findByZipCodeGreaterThan(@PathVariable Long zipCode) {
		return addressService.findByZipCodeGreaterThan(zipCode);
	}

	@GetMapping("/address/city/{city}")
	public List<Address> findByCityLike(@PathVariable String city) {
		return addressService.findByCityLike(city);
	}
}
