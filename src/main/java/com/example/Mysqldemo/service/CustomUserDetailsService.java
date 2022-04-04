package com.example.Mysqldemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Mysqldemo.model.Role;
import com.example.Mysqldemo.model.User;
import com.example.Mysqldemo.repository.RoleRepository;
import com.example.Mysqldemo.repository.UserRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	/**
	 * Declare the user and role repositories.
	 */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * `BCryptPasswordEncoder` for the password encryption.
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * Declare the session
	 */
	@Autowired
	HttpSession session;

	/**
	 * Create a method for find the user by email.
	 */
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * method for save a new user, encrypt the password and set a role for the user.
	 * For now, we will use the role `ADMIN` for all newly registered user.
	 */
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	/**
	 * method for handling the login mechanism that checks(or) compares username
	 * with the user from MongoDB collection.
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	User user = userRepository.findByEmail(email);
	System.out.println(user);
	if(user != null) {
		System.out.println("yam");
	session.setAttribute("email",user.getEmail());
	session.setAttribute("username", user.getUsername());
	session.setAttribute("id", user.getId());
	List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	return buildUserForAuthentication(user, authorities);
	} else {
	throw new UsernameNotFoundException("username not found");
	}
	}

	/**
	 * method has a method for converting the user roles as GrantedAuthority
	 * collection.
	 */
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		userRoles.forEach((role) -> {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		});

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	/**
	 * method for connecting MongoDB user to Spring Security user as called from the
	 * `loadUserByUsername` method.
	 */
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}