package com.ronit.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ronit.entities.Company;
import com.ronit.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//	/ 	List <Coupon> findAllCustomerCoupons(int customerId, int couponID);
	boolean ExistsByEmailAndPassword(String email, String password);
	Customer FindByEmailAndPassword(String email, String password);
//
	boolean ExistsByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
//
	boolean ExistsByNameAndEmail(String name, String email);
	//
	Company findByNameAndEmail(String name, String email);

	

}
