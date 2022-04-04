package com.example.Mysqldemo;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Mysqldemo.controller.ProductController;
import com.example.Mysqldemo.model.Role;
import com.example.Mysqldemo.repository.RoleRepository;

/**
 * same as @Configuration @EnableAutoConfiguration @ComponentScan.
 * 
 * This annotation is responsible for setting up which autoconfiguration to
 * enable and where to look for spring bean components and configurations.
 */

@SpringBootApplication
public class SpringbootAppWithMysqlApplication {

	/**
	 * The main() method uses Spring Boot’s SpringApplication.run() method to launch
	 * an application.
	 * 
	 */
	public static void main(String[] args) {
		new File(ProductController.uploadDirectory).mkdir();
		SpringApplication.run(SpringbootAppWithMysqlApplication.class, args);
	}
	
	/**
	 * There is also a CommandLineRunner method marked as a @Bean, and this runs on
	 * start up. It retrieves all the beans that were created by your application or
	 * that were automatically added by Spring Boot.
	 * 
	 * @param RoleRepository is a interface
	 * @return  if the role is set to admin it saved as new admin role
	 * 			if the role is set to user it saved as new user role
	 * 
	 */
	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

		return args -> {

			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};

	}
}
