package com.ronit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.enums.Category;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerController extends ClientController{
	
	public CustomerController() {
		
	}
	
	public boolean login(String email, String passwaord) {
		return false;
		
	}
	
	public void PurchaseCoupon(Coupon coupon) {
		
	}
	
	public List <Coupon> getCustomerCoupons(){
		return null;
				
	}
	
	List<Coupon> getCustomerCoupons(int customerId, Category category){
		return null;
		
	}
	
	List<Coupon> getCustomerCoupons(int customerId, double maxPrice){
		return null;
		
	}
	
	Customer getCustomerDetails() {
		return null;
		
	}
	

}
