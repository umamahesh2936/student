package com.cglia.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.dao.AddressDao;
import com.cglia.student.dto.Address;
import com.cglia.student.dto.Student;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public List<Address> getByStudentId(int id) {
		return addressDao.findByStudentId(id);
	}

	public List<Address> getAll() {
		return addressDao.getAll();
	}

	public String saveAddress(Address address, int id) {
		return addressDao.saveAddress(address, id);
	}

	public String updateAddress(Address address, int id) {
		Address address2 = getById(id);
		if (address2 != null) {
			Student student = getStudentByAddressId(id);
			return addressDao.saveAddress(address, student.getStudentId());
		}
		return addressDao.message(address, id);
	}

	public String deleteAddress(int id) {
		return addressDao.deleteAddress(id);
	}

	public Address getById(int id) {
		return addressDao.getById(id);
	}

	public Student getStudentByAddressId(int id) {
		return addressDao.getStudentByAddresId(id);
	}

	public List<Address> findByVillage(String village) {
		return addressDao.findByVillage(village);
	}

	public List<Address> findByZipCodeGreaterThan(Long zipCode) {
		return addressDao.findByZipCodeGreaterThan(zipCode);
	}

	public List<Address> findByCityLike(String city) {
		return addressDao.findByCityLike(city);
	}

}
