package com.ronit.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ronit.entities.Company;
import com.ronit.entities.Customer;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.repositories.CompanyRepository;
import com.ronit.repositories.CouponRepository;
import com.ronit.repositories.CustomerRepository;

@Service
@Scope("prototype")
public class AdminService extends ClientService {

	@Autowired
	public AdminService(CompanyRepository companyrepository, CouponRepository couponrepository,
			CustomerRepository customerrepository) {
		this.companyrepository = companyrepository;
		this.couponrepository = couponrepository;
		this.customerRepository = customerrepository;
	}

	public boolean login(String email, String passwaord) {
		return companyrepository.ExistsByEmailAndPassword(email, passwaord);
	}

	// Company
	public void addCompany(Company company) throws CouponSystemException {
//		Optional<Company> opt = this.
		if (companyrepository.existsByNameAndEmail(company.getName(), company.getEmail())) {
			throw new CouponSystemException("addCompany faild - company with this name and email already exist ");

		} else {
			
			companyrepository.save(company);
		}

	}

	public void updateCompany(Company company) throws CouponSystemException {
		Optional<Company> opt = this.companyrepository.findById(company.getCompanyID());
		if (opt.isPresent()) {
			Company companyFromDB = opt.get();
			companyFromDB.setEmail(company.getEmail());
			companyFromDB.setPassword(company.getPassword());
		} else {
			throw new CouponSystemException("updateCompany faild - company not found ");
		}

	}

	public void deleteCompany(int companyID) throws CouponSystemException {
		Optional<Company> opt = this.companyrepository.findById(companyID);
		if (opt.isEmpty()) {
			throw new CouponSystemException("deleteCompany faild - Company with this id not found");
		}
		companyrepository.deleteById(companyID);
	}

	public Company getOneCompany(int companyID) throws CouponSystemException {
		Optional<Company> opt = this.companyrepository.findById(companyID);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CouponSystemException("getOneCompany faild - not found");
		}

	}

	public List<Company> getAllCompanies() {
		return companyrepository.findAll();

	}

	public void addCustomer(Customer customer) throws CouponSystemException {
		if (this.customerRepository.ExistsByFirstNameAndLastNameAndEmail(customer.getFirstName(),
				customer.getLastName(), customer.getEmail())) {
			throw new CouponSystemException("addCustomer faild - company with this name and email already exist ");
		}
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getOneCustomer(int CustomerID) throws CouponSystemException {
		Optional<Customer> opt = this.customerRepository.findById(CustomerID);
		if (opt.isEmpty()) {
			throw new CouponSystemException("getOneCustomer faild - customer not found");
		}
		return opt.get();
//		return this.customerRepository
//				.findById(CustomerID)
//				.orElseThrow(() -> new CouponSystemException("getOneCustomer faild - customer not found"));
////	
//		return this.customerRepository
//				
//				.findById(CustomerID)
//				
//				.orElseGet(() -> null);

//		return customerRepository.getById(CustomerID);

	}

//	int customerId
	public void updateCustomer(Customer customer) throws CouponSystemException {
		Optional<Customer> opt = this.customerRepository.findById(customer.getId());
		if (opt.isEmpty()) {
			throw new CouponSystemException("updateCustomer faild - customer not found");
		}

		Customer customerFromDb = opt.get();
		customerFromDb.setFirst_name(customer.getFirstName());
		customerFromDb.setLast_name(customer.getLastName());
		customerFromDb.setEmail(customer.getEmail());
		customerFromDb.setPassword(customer.getPassword());
		customerFromDb.setCoupons(customer.getCoupons());

	}

	public void deleteCustomer(int customerId) throws CouponSystemException {
		Optional<Customer> opt = this.customerRepository.findById(customerId);
		if (opt.isEmpty()) {
			throw new CouponSystemException("deleteCustomer faild - Customer with this id not found");
		}
		customerRepository.deleteById(customerId);
	}

}
