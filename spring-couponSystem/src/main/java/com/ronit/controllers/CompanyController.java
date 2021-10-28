package com.ronit.controllers;

import java.util.List;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.enums.Category;

@RestController
@RequestMapping(value = "/Company")
public class CompanyController extends ClientController {
	
	public CompanyController() {
		
	}
	
	public boolean login(String email, String passwaord) {
		return false;
		
	}
	
	public int addCoupon(Coupon coupon) {
		return 0;
		
	}
	
	void updateCoupon(Coupon coupon) {
		
	}
	
	void deleteCoupon(int couponID) {
		
	}
	
	List<Coupon> getCompanyCoupons(int companyId, Category category){
		return null;
		
	}
	
	List<Coupon> getCompanyCoupons(int companyId, double maxPrice){
		return null;
		
	}
	
	Company getCompanyDetails() {
		return null;
		
	}
}
