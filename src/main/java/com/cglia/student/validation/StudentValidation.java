package com.cglia.student.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cglia.student.dto.Address;
import com.cglia.student.dto.Laptop;
import com.cglia.student.dto.Student;

@Component
public class StudentValidation {

	public List<Student> validateByStatus(List<Student> list) {
		List<Student> modifiedList = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Student student : list) {
				if (student.getStatus() == 1) {
					modifiedList.add(student);
				}
			}
			return modifiedList;
		}
		return Collections.emptyList();
	}

	public List<Laptop> laptopValidate(List<Laptop> list) {
		List<Laptop> modifiedList = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Laptop laptop : list) {
				if (laptop.getStatus() == 1) {
					modifiedList.add(laptop);
				}
			}
			return modifiedList;
		}
		return Collections.emptyList();
	}

	public List<Address> addressValidate(List<Address> list) {
		List<Address> modifiedList = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Address address : list) {
				if (address.getStatus() == 1) {
					modifiedList.add(address);
				}
			}
			return modifiedList;
		}
		return Collections.emptyList();
	}
}
