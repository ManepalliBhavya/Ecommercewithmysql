package com.example.Mysqldemo.configaration;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Mysqldemo.service.CustomUserDetailsService;

/**
 * Spring Boot configuration class, enable Spring Web Security and extends
 * Spring Security `WebSecurityConfigurerAdapter`
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Declare the previously created `BCryptPasswordEncoder` and
	 * `CustomizeAuthenticationSuccessHandler` after the class name.
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

	/**
	 * bean for the Spring Security `UserDetailsService` that use the
	 * `CustomUserDetailsService` class.
	 */
	@Bean
	public UserDetailsService jspUserDetails() {
		return new CustomUserDetailsService();
	}

	/**
	 * override method for a manage authentication mechanism t hat uses
	 * `UserDetailsService` and Bcrypt password encoder.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = jspUserDetails();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}

	/**
	 * override method for securing the HTTP requests.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/signup").permitAll()		
				.antMatchers("/dashboard").hasAuthority("ADMIN")
				.antMatchers("/productadd").hasAuthority("ADMIN")
				.antMatchers("/productlist").hasAnyAuthority("ADMIN", "USER")
				.antMatchers("/productdelete/**").hasAuthority("ADMIN")
				.antMatchers("productupdate/**").hasAuthority("ADMIN")
				.antMatchers("userProductList").hasAuthority("USER")
				.antMatchers("/productdetails/**").hasAuthority("ADMIN")
				.antMatchers("/userProductdetails/**").hasAuthority("USER")
				.antMatchers("/search").hasAuthority("ADMIN")
				.antMatchers("/userSearch").hasAuthority("USER")

				.antMatchers("/categoryadd").hasAuthority("ADMIN")
				.antMatchers("/categorylist").hasAnyAuthority("ADMIN", "USER")
				.antMatchers("/categorydelete/**").hasAuthority("ADMIN")
				.antMatchers("categoryupdate/**").hasAuthority("ADMIN")
				.antMatchers("indexCategory/**").hasAuthority("ADMIN")

				.antMatchers("/supplieradd").hasAuthority("ADMIN")
				.antMatchers("/supplierlist").hasAuthority("ADMIN")
				.antMatchers("/supplierdelete/**").hasAuthority("ADMIN")
				.antMatchers("supplierupdate/**").hasAuthority("ADMIN")
				.antMatchers("indexSupplier/**").hasAuthority("ADMIN")

				.antMatchers("/welcomeOrderPage").hasAuthority("USER")

				.anyRequest().authenticated().and().csrf().disable().formLogin()
				.successHandler(customizeAuthenticationSuccessHandler).loginPage("/login")
				.failureUrl("/login?error=true").usernameParameter("email").passwordParameter("password").and();
	}

	/**
	 * an override method to exclude static resources that use in this web
	 * application.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}