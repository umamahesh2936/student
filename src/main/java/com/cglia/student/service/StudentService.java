package com.cglia.student.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.dao.StudentDao;
import com.cglia.student.dto.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public String saveStudent(Student student) {
		return dao.saveStudent(student);
	}

	public String deleteStudent(int id) {
		return dao.deleteStudent(id);
	}

	public String updateStudent(Student student) {
		return dao.saveStudent(student);
	}

	public Student getById(int id) {
		return dao.getById(id);
	}

	public List<Student> getAll() {
		return dao.getAll();
	}

	public List<Student> getStudentBirthGreateThan(Date date) {
		return dao.getBirthDataGreaterThan(date);
	}

	public List<Student> findByAgeLessThanAndOrderByDOB(int age) {
		return dao.findByAgeLessThanAndOrderByBirthDate(age);
	}

	public List<Student> findByStudentNameContaining(String s) {
		return dao.findByNameContaining(s);
	}

	public List<Student> findByBirhtDateBetween(Date d1, Date d2) {
		return dao.findByStudentBetween(d1, d2);
	}

}

//{
//    "studentId":11,
//    "studentName":"Ramesh",
//    "birthDate":"1998-03-01",
//    "age":37,
//    "laptop":{
//        "laptopId":7,
//    "laptopBrand":"ASUS",
//    "laptopManufactureDate":"2000-05-21",
//    "modelNo":"HRJ5"},
//        "address":[
//        {"addressId":105,
//    "village":"hderabad","city":"charminar",
//    "state":"telengana",
//    "zipCode":579809
//    },
//    {"addressId":106,
//    "village":"kondapalli","city":"khammam",
//    "state":"telengana",
//    "zipCode":565765
//    }
//    ],
//    "course":[
//        {
//            "courseId":7,
//    "courseName":"Geology",
//    "courseCode":"GEO34"
//    },
//    {  "courseId":8,
//    "courseName":"Biology",
//    "courseCode":"BIO43"}
//    ]
//}