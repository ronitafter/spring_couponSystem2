package com.ronit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ronit.entities.Company;
import com.ronit.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmailAndPassword(String email, String password);
	Customer findByEmailAndPassword(String email, String password);
	boolean existsByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
	Company findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

	

}
