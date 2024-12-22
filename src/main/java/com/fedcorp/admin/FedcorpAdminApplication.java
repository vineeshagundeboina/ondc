package com.fedcorp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class FedcorpAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(FedcorpAdminApplication.class, args);
		
	}
	

	
	
	
	

}
