package com.cglia.student.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cglia.student.dto.Laptop;
@EnableJpaRepositories
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	List<Laptop> findByLaptopBrandOrderByLaptopManufactureDateDesc(String laptopBrand);

	List<Laptop> findByModelNoLike(String modelNoPattern);

	List<Laptop> findAllByOrderByLaptopIdDesc();
}
