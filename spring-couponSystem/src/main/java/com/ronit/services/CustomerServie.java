package com.ronit.services;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.enums.Category;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.repositories.CouponRepository;
import com.ronit.repositories.CustomerRepository;

import jdk.jfr.DataAmount;

@Service
public class CustomerServie extends ClientService {

	private CouponRepository couponrepository;
	private CustomerRepository customerrepository;
	private int id;
	Coupon coupon = null;

	// login
	public boolean login(String email, String passwaord) {
		if (customerrepository.existsByEmailAndPassword(email, passwaord)) {
			Customer customer = customerrepository.findByEmailAndPassword(email, passwaord);
			id = customer.getId();
			return true;
		}

		return false;
//		return customerrepository.isCustomerExistByEmailAndPassword(email, passwaord);

	}

	@Autowired
	public CustomerServie(CouponRepository couponrepository, CustomerRepository customerrepository) {
		this.couponrepository = couponrepository;
		this.customerrepository = customerrepository;

	}

	// public void PurchaseCoupon(int customerId, int couponId) throws
	// CouponSystemException {
	public void PurchaseCoupon(int couponId) throws CouponSystemException {
		Optional<Coupon> opt = this.couponrepository.findById(couponId);
		if (opt.isEmpty()) {
			// and is bigger
			throw new CouponSystemException("PurchaseCoupon faild - coupon with this Id not found");
		}
		if (coupon.getAmount() <= 0) {
			throw new CouponSystemException("PurchaseCoupon faild - amount for this coupo is 0");
		} else {

			Customer customer = customerrepository.getById(couponId);
			coupon.setAmount(coupon.getAmount() - 1);
			customer.addCoupon(coupon);
			customerrepository.save(customer);
		}

	}

//	int couponID, Coupon coupon		
	public List<Coupon> getAllCustomerCoupons(int customerId) throws CouponSystemException {
		if (couponrepository.findByCustomersId(customerId).isEmpty()) {
			throw new CouponSystemException(
					"getAllCustomerCoupons faild - Coupons not found in this category for this customer");

		} else {
			return new ArrayList<Coupon>(couponrepository.findByCustomersId(customerId));

		}

	}

	public List<Coupon> getCustomerCoupons(int customerId, Category category) throws CouponSystemException {
		if (couponrepository.findByCompanyIdAndCategory(customerId, category).isEmpty()) {
			throw new CouponSystemException(
					"getCustomerCoupons faild - Coupons not found in this category for this customer");
		} else {

			return new ArrayList<Coupon>(couponrepository.findByCompanyIdAndCategory(customerId, category));
		}

	}

	public List<Coupon> getCustomerCoupons(int customerId, int maxPrice) throws CouponSystemException {
		if (couponrepository.findCouponsByCustomersIdAndPrice(customerId, maxPrice).isEmpty()) {
			throw new CouponSystemException("getCustomerCoupons faild - customerId not found");
		} else {
			return new ArrayList<Coupon>(couponrepository.findCouponsByCustomersIdAndPrice(customerId, maxPrice));
		}
	}

	public Customer getAllCustomerDetails(int customerId) throws CouponSystemException {
		Optional<Customer> opt = this.customerrepository.findById(customerId);
		if (opt.isEmpty()) {
			throw new CouponSystemException("getAllCustomerDetails faild - Customer not found");
		}

		return opt.get();
	}

}
