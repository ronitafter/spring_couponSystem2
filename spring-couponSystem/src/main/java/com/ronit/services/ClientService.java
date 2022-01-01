package com.ronit.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.ronit.repositories.CompanyRepository;
import com.ronit.repositories.CouponRepository;
import com.ronit.repositories.CustomerRepository;

public abstract class ClientService {
	
	@Autowired
	protected CompanyRepository companyrepository;
	@Autowired
	protected CouponRepository couponrepository;
	@Autowired
	protected CustomerRepository customerRepository;
	
	public abstract boolean login(String email, String passwaord);
	

}
