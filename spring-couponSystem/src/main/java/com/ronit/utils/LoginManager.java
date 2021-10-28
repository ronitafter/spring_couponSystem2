package com.ronit.utils;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerServies;

@Component
public class LoginManager {
	
//	@Autowired
//	private ApplicationContext applicationcontext;
 // clientService = applicationcontext.getBean(adminService.classe)
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerServies customerServies;
	@Autowired
	private AdminService adminService;

	public ClientService login(String email, String passwaord, ClientType clientType) throws CouponSystemException {
		ClientService clientService = null;
		switch (clientType) {
		case COMPANY:
			if (this.companyService.login(email, passwaord)) {
				return companyService;
			} else {
				throw new CouponSystemException("login as company failed");
			}
		case CUSTOMER:
			if (this.customerServies.login(email, passwaord)) {
				return customerServies;
			} else {
				throw new CouponSystemException("login as CUSTOMER failed");
			}
		case ADMINISTRATOR:
			if (this.adminService.login(email, passwaord)) {
				return adminService;
			} else {
				throw new CouponSystemException("login as ADMINISTRATOR failed");
			}

		default:
			break;
		}

		return clientService;
	}

}
