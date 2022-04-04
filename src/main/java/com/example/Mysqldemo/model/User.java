package com.example.Mysqldemo.model;


/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * To make this class a Spring Data document and assign to user collection
 */
@Entity
@Table(name = "user")
public class User {
	/**
	 * @Id - This annotation is placed on a specific field that holds the persistent
	 *     identifying properties. This field is treated as a primary key in
	 *     database.
	 * 
	 * And also Declare all required fields or variables for user data.
	 */
	@Id
	@Column(name = "user_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;
	private String username;
	private boolean enabled;
	private String city;
	private String phoneNo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
	@JoinTable(            
	name = "user_roles",            
	joinColumns = @JoinColumn(name = "user_id"),            

	inverseJoinColumns = @JoinColumn(name = "role_id")            )    

	private Set<Role> roles;
	
	/**
	 * Generate default constructor
	 */
	public User() {
		
	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	
	public User(long id, String email, String password, String username, boolean enabled, String city, String phoneNo,
			Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.enabled = enabled;
		this.city = city;
		this.phoneNo = phoneNo;
		this.roles = roles;
	}

	
	/**
	 * Generate getters and setters for all above fields.
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", enabled=" + enabled + ", city=" + city + ", phoneNo=" + phoneNo + ", roles=" + roles + "]";
	}
	

}