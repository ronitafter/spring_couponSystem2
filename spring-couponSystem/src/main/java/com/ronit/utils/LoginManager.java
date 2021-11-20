package com.ronit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerServie;

@Component
public class LoginManager {
	
	@Autowired
	private ApplicationContext context;
 // clientService = applicationcontext.getBean(adminService.classe)
	

	public ClientService login(String email, String passwaord, ClientType clientType) throws CouponSystemException {
		ClientService clientService = null;
		switch (clientType) {
		case COMPANY:
			 clientService = context.getBean(CompanyService.class);
			 break;
		case CUSTOMER:
			clientService = context.getBean(CustomerServie.class);
			break;
		case ADMINISTRATOR:
			clientService = context.getBean(AdminService.class);
			break;
		}

		if (clientService.login(email, passwaord)) {
			return clientService;
		} else {
			throw new CouponSystemException("login as company failed");
		}
	}

}
