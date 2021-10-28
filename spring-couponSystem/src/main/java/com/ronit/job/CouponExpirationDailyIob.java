package com.ronit.job;

import com.ronit.repositories.CouponRepository;

import java.sql.Date;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ronit.entities.Coupon;

@Component
@Scope("singleton")
public class CouponExpirationDailyIob implements Runnable {
	Date enddate;
	private CouponRepository couponRepository;
	private static final long TWENTY_FOUR_HOURSE = 1000 * 60 * 60 * 24;

	@Autowired
	private CouponExpirationDailyIob() {

	}

	public void run() {
		// 	if(couponRepository.findByEndDate(java.sql.Date.valueOf("2020-5-20"))){
		LocalTime time1 = LocalTime.now();  
		 LocalTime time2=time1.minusHours(2);  
		  LocalTime time3=time2.minusMinutes(34);  
		if(couponRepository.findByEndDate(time1)){
			
		}
		couponRepository.deleteExpiredCoupons();
	}

}
