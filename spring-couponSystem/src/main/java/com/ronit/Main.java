package com.ronit;

import org.springframework.context.ApplicationContext;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ApplicationContext Context = SpringApplication.run(Main.class);
//		SpringApplication.run(Main.class);
//		System.out.println(Category.values());

	}

}
