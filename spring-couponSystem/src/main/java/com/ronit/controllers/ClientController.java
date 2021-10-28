package com.ronit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ronit.entities.Company;
import com.ronit.entities.Customer;

public abstract class ClientController {

	public ClientController() {

	}

    @Autowired
	public boolean login(String email, String passwaord) {
		return false;

	}

	public int addCompany(Company company) {
		return 0;

	}

	public void updateCompany(Company company) {

	}

	public void deleteCompany(int companyID) {

	}

	public List<Company> getAllCompanies() {
		return null;

	}

	public Company getOneCompany(int companyID) {
		return null;

	}

	public int addCustomer(Customer customer) {
		return 0;

	}
	
	public void updateCustomer(Customer customer){
		
	}
	
	public void deleteCustomer(int CustomerID) {
		
	}
	
	public List<Customer> getAllCustomers() {
		return null;
		
	}
	
	public Customer getOneCustomer(int CustomerID){
		return null;
		
	}
}
