package com.example.Mysqldemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * Importing all the packages whatever needed in class
 * 
 */
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Entity - This is a marker annotation which indicates that this class is an
 *         entity. This annotation must be placed on the class name.
 */
@Entity
@Table(name = "role")
public class Role {

	/**
	 * @Id - This annotation is placed on a specific field that holds the persistent
	 *     identifying properties. This field is treated as a primary key in
	 *     database.
	 * 
	 *     And also Declare all required fields or variables for role data.
	 */
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String role;

	/**
	 * Generate default constructor.
	 */
	public Role() {

	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Role(long id, String role) {
		super();
		this.id = id;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}