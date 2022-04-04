package com.example.Mysqldemo.configaration;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration: It is a class-level annotation. The class annotated
 *                 with @Configuration used by Spring Containers as a source of
 *                 bean definitions.
 * 
 *                 To make the class as a Spring Boot configuration class, add
 *                 this annotation and implements Spring `WebMvcConfigurer`
 *                 before the class name.
 * 
 */

@Configuration
public class PageConfig implements WebMvcConfigurer {

	// BCryptPasswordEncoder bean.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/**
	 * Using an override method to register the addViewController and setViewName.
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/login").setViewName("login");

		registry.addViewController("/productadd").setViewName("productadd");
		registry.addViewController("/productlist").setViewName("productlist");
		registry.addViewController("/userproductlist").setViewName("userProductList");
		registry.addViewController("/productupdate/{id}").setViewName("updateProduct");
		registry.addViewController("/productdelete/{id}").setViewName("productdelete");
		registry.addViewController("/search").setViewName("search");
		registry.addViewController("/userSearch").setViewName("userSearch");
		registry.addViewController("/productdetails").setViewName("productDetails");
		registry.addViewController("/userProductdetails").setViewName("userProductDetails");

		registry.addViewController("/categoryadd").setViewName("categoryadd");
		registry.addViewController("/categorylist").setViewName("categorylist");
		registry.addViewController("/categoryupdate/{id}").setViewName("updateCategory");
		registry.addViewController("/categorydelete/{id}").setViewName("categorydelete");
		registry.addViewController("/indexCategory").setViewName("indexCategory");

		registry.addViewController("/supplieradd").setViewName("supplieradd");
		registry.addViewController("/supplierlist").setViewName("supplierlist");
		registry.addViewController("/supplierupdate/{id}").setViewName("updateSupplier");
		registry.addViewController("/supplierdelete/{id}").setViewName("supplierdelete");
		registry.addViewController("/indexSupplier").setViewName("indexSupplier");

		registry.addViewController("/welcomeOrderPage").setViewName("welcomeOrderPage");
	}
}