package com.ronit.services;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.enums.Category;
import com.ronit.exceptions.CouponSystemException;

@Service
@Transactional
public class CompanyService extends ClientService {

	private int id; // ?

	public boolean login(String email, String passwaord) {
		if (companyrepository.ExistsByEmailAndPassword(email, passwaord)) {
			Company company = companyrepository.FindByEmailAndPassword(passwaord, passwaord);
			id = company.getCompanyID();
			return true;
		}
		return false;
//		return companyrepository.isCompanyExistsByEmailAndPassword(email, passwaord);

	}

//	public int addCoupon(Company company, Coupon coupon) {	
	public void addCoupon(int companyId, Coupon coupon) throws CouponSystemException {
		if (this.couponrepository.existsByCompanyIdAndTitle(companyId, coupon.getTitle())) {
			throw new CouponSystemException("addCoupon faild - coupon already exist for this company ");
		}

		Company company = companyrepository.findById(companyId).get();
		company.addCoupon(coupon);

	}

	public void UpdateCoupon(int companyId, Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = this.couponrepository.findById(coupon.getId());
		if (opt.isEmpty()) {
			throw new CouponSystemException("UpdateCoupon faild - coupon not found");
		}

		Coupon couponFromDb = opt.get();
		if (couponFromDb.getId() != companyId) {
			throw new CouponSystemException("UpdateCoupon faild - coupon not belong to this company");
		}

		couponFromDb.setAmount(coupon.getAmount());
		couponFromDb.setCategory(coupon.getCategory());
		couponFromDb.setDescription(coupon.getDescription());
		couponFromDb.setStart_date(coupon.getStart_date());
		couponFromDb.setEnd_date(coupon.getEnd_date());
		couponFromDb.setImage(coupon.getImage());
		couponFromDb.setPrice(coupon.getPrice());
		couponFromDb.setTitle(coupon.getTitle());

	}

	public void deleteCoupon(int companyId, Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = this.couponrepository.findById(coupon.getId());
		if (opt.isEmpty()) {
			throw new CouponSystemException("deleteCoupon faild - coupon not found");
		}
		Coupon couponFromDb = opt.get();
		if (couponFromDb.getId() != companyId) {
			throw new CouponSystemException("deleteCoupon faild - coupon not belong to this company");
		}

		couponrepository.deleteById(coupon.getId());
		// couponrepository.delete(coupon);

	}

	public List<Coupon> getCompanyCoupons(int companyId, Category category) throws CouponSystemException {
		if (couponrepository.findByCompanyIdAndCategory(companyId, category).isEmpty()) {
			throw new CouponSystemException(
					"getCompanyCoupons faild - Coupons not found in this category for this company");
		} else {
			return new ArrayList<Coupon>(couponrepository.findByCompanyIdAndCategory(companyId, category));
		}
	}

	public List<Coupon> getCompanyCoupons(int companyId, double maxPrice) throws CouponSystemException {
		if (couponrepository.findByCompanyIdAndPrice(companyId, maxPrice).isEmpty()) {
			throw new CouponSystemException("getCompanyCoupons faild - company not found");
		} else {
			return new ArrayList<Coupon>(couponrepository.findByCompanyIdAndPrice(companyId, maxPrice));
		}
	}

//	public Optional<Coupon> getAllCompanyCoupons(int companyId, int couponId) {
	public List<Coupon> getAllCompanyCoupons(int companyId) throws CouponSystemException {
		if (couponrepository.findCouponsByCompanyId(companyId).isEmpty()) {
			throw new CouponSystemException("getAllCompanyCoupons faild - no coupons found for this company");

		} else {

		}
		return new ArrayList<Coupon>(couponrepository.findCouponsByCompanyId(companyId));
	}
	
	public Company getCompanyDetails(int comanyId) throws CouponSystemException {
		Optional<Company> opt = this.companyrepository.findById(comanyId);
		if (opt.isEmpty()) {
			throw new CouponSystemException("getCompanyDetails faild - company with this id not found");
		}

		return opt.get();

	}

}
