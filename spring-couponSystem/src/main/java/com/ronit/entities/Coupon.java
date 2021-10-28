package com.ronit.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ronit.enums.Category;

@Entity
@Table(name = "coupon")	
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne()
	@JoinColumn(name = "company_id")
	private Company company;
	@Column(name = "category_id")
	@Enumerated(value = EnumType.ORDINAL)
	private Category category;
	private String title;
	private String description;
	@Column(name = "start_date")
	private Date startDate;
	// 	@Column(name = "start_date")
	private Date endDate;
	private int amount;
	private double price;
	private String image;

	public Coupon() {
	}

	public Coupon(String title, double price, int id) {

	}

	public Coupon(Category category, String title, String description, Date startDate, Date endDate, int amount,
			double price, String image) {
		super();
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Coupon(Company company, Category category, String title, String description, Date start_date, Date end_date,
		int amount, double price, String image) {
		this.company = company;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Coupon(int id, Company company, Category category, String title, String description, int amount, double price,
			String image, Date endDate, Date start_date) {
		super();
		this.id = id;
		this.company = company;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = start_date;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return startDate;
	}

	public void setStart_date(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEnd_date() {
		return endDate;
	}

	public void setEnd_date(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", category=" + category + ", title=" + title + ", description=" + description
				+ ", start_date=" + startDate + ", end_date=" + endDate + ", amount=" + amount + ", price=" + price
				+ ", image=" + image + "]";
	}

	

}
