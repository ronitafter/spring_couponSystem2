package com.ronit;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ronit.entities.Company;
import com.ronit.enums.Category;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.services.AdminService;
import com.ronit.utils.LoginManager;

@EnableScheduling
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class);
//		context.getBean(AdminService.class);
//		SpringApplication.run(Main.class);
//		System.out.println(Arrays.toString(Category.values()));
		
		LoginManager loginManager = context.getBean(LoginManager.class);
		try {
			AdminService adminService = (AdminService) loginManager.login("admin@admin.com","admin", ClientType.ADMINISTRATOR);
			List<Company> companies = adminService.getAllCompanies();
			System.out.println(companies);
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}

	}

}
