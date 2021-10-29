package com.ronit.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String password;
	
	private List<Coupon> coupons;
//	private Coupon coupon;

	public Customer() {

	}

	public Customer(int id, String first_name, String last_name, String email, String password) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
	}

	public Customer(int id, String first_name, String last_name, String email, String password, List<Coupon> coupons) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public void addCoupon(Coupon coupon) {
		if (this.coupons == null) {
			this.coupons = new ArrayList<Coupon>();
		}
		this.coupons.add(coupon);
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + email
				+ ", password=" + password + ", coupons=" + coupons + "]";
	}

}
