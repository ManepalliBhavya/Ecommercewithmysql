package com.example.Mysqldemo.configaration;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Implements WebMvcConfigurer to the class
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {

	/**
	 * an override method
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
	}
}
