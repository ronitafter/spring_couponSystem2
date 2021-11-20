package com.ronit.job;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ronit.repositories.CouponRepository;

//@Component
@Scope("singleton")
public class CouponExpirationDailyIob implements Runnable {
	private Thread thread;
	@Autowired
	private CouponRepository couponRepository;


	public void run() {
		System.out.println(">>> " + Thread.currentThread().getName() + "  started");
		while(true) {
			try {
//				TimeUnit.HOURS.sleep(24); // for production
				TimeUnit.SECONDS.sleep(5); // for testing
			} catch (InterruptedException e) {
				break;
			}
			System.out.println(">>> " + Thread.currentThread().getName() + "  is now deleting expired coupons");
			couponRepository.deleteExpiredCoupons();
		}
		System.out.println(">>> " + Thread.currentThread().getName() + "  stop");
	}
	
	@PostConstruct
	public void startTheThread() {
		this.thread = new Thread(this, "CouponExpirationDailyIob");
		this.thread.start();
	}
	
	@PreDestroy
	public void stopTheThread() {
		this.thread.interrupt();
	}

}
