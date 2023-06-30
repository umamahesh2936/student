package com.cglia.student.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cglia.student.dto.Address;
import com.cglia.student.dto.Student;
import com.cglia.student.repostitory.AddressRepository;
import com.cglia.student.repostitory.StudentRepository;
import com.cglia.student.validation.StudentValidation;

@Repository
public class AddressDao {
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	StudentRepository studentRepositorys;
	@Autowired
	StudentValidation studentValidation;

//working
	public List<Address> findByStudentId(int id) {
		Student student = studentRepositorys.findById(id).get();
		if (student != null) {
			return student.getAddress();
		}
		return Collections.emptyList();
	}

	@Transactional
	public String saveAddress(Address address, int id) {
		try {
			Student student = studentRepositorys.findById(id).get();
			if (address != null && student != null && student.getStatus() == 1) {
				address.setStudent(student);
				address.setStatus(1);
				List<Address> list = student.getAddress();
				list.add(address);
				student.setAddress(list);
				studentRepositorys.save(student);
				return "Successfully Added Address";
			}
		} catch (Exception e) {
			return " Student Details not Found";
		}
		return null;
	}

	public String deleteAddress(int id) {
		Address a = addressRepository.getById(id);
		if (a != null && a.getStatus() == 1) {
			addressRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Invalid ID";
	}

	@Transactional
	public Address getById(int id) {
		Optional<Address> optional = addressRepository.findById(id);
		if (!optional.isEmpty() && optional.get().getAddressId() == 1) {
			return optional.get();
		}
		return null;
	}

	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	public String message(Address address, int id) {
		return "Invalid Id";
	}

	public Student getStudentByAddresId(int id) {
		Address address = getById(id);
		Student student = address.getStudent();
		return student;
	}

	public List<Address> findByVillage(String village) {
		List<Address> list = addressRepository.findByVillage(village);
		return studentValidation.addressValidate(list);
	}

	public List<Address> findByZipCodeGreaterThan(Long zipCode) {
		List<Address> list = addressRepository.findByZipCodeGreaterThan(zipCode);
		return studentValidation.addressValidate(list);
	}

	public List<Address> findByCityLike(String city) {
		List<Address> list = addressRepository.findByCityLike(city);
		return studentValidation.addressValidate(list);
	}
}
