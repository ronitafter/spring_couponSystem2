package com.ronit.repositories;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ronit.entities.Coupon;
import com.ronit.enums.Category;
import com.ronit.exceptions.CouponSystemException;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	// ************************ Company ************************

	@Modifying
	@Transactional
	@Query(value = "delete from coupons where end_date<now()", nativeQuery = true)
//	@Query(value = "delete from Coupon c where c.endDate < now()")
	void deleteExpiredCoupons();

	// find coupons by company_Id and price
	List<Coupon> findByCompanyIdAndPrice(int companyId, double maxPrice);

	// is company exist By Id And Title
	boolean existsByCompanyIdAndTitle(int companyId, String title);

	// findCompany Coupons By id and Category
	List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);
	
	// ?
	List<Coupon> findCouponsByCompanyId(int companyId);
	// findCouponsByCompanyIdAndCouponId
    @Query("from Coupon as c where c.company.id = :companyId and c.id = :couponId")
	List<Coupon> findCouponsByCompanyIdAndCouponId(int companyId, int couponId);

	// void deletCompanyCoupons(int companyID)
	// find all company coupons
//List<Coupon> findAllCompanyCoupons(int CompanyID, int couponId);

	// ************************ Customer ************************
	// find coupon by date
	boolean findByEndDate(LocalTime time);
	boolean findByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);
//	boolean findByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);


	// ?
	@Query(value = "select coupon. * from coupons join customers_coupons on"
			+ "coupon.id=customers_coupons.coupon_id where customer_id=id and maxPrice<=price", nativeQuery = true)
	List<Coupon> findCouponsByCustomersIdAndPrice(int customerId, int maxPrice);	
	// get Customer Coupons by customerID and couponID
	@Query(value = "select coupon. * from coupons join customers_coupons on"
			+ "coupon.id=customers_coupons.coupon_id where customer_id=id and category_id=categoryId", nativeQuery = true)
	List<Coupon> getCustomersCoupons(@Param("customerId") int customerId, @Param("categoryId") int categoryId);
	
	
	
	// 
	List<Coupon> findByCustomersIdAndCategory(int customerId, Category category);
	// Coupon coupon
	List<Coupon> findByCustomersId(int customerId);
// find Customer Coupon by customerID and couponID
// void deletCouponPurchase(int customerID, int couponID) throws
// deletCouponPurchaseOfCustomer(int customerID) 
}
