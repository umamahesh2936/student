package com.cglia.student.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.cglia.student.dto.Address;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByVillage(String village);

	List<Address> findByZipCodeGreaterThan(Long zipCode);

	@Query("SELECT a FROM Address a WHERE a.city LIKE %:city%")
	List<Address> findByCityLike(@Param("city") String city);
}
