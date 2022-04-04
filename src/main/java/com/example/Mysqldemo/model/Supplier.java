package com.example.Mysqldemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * Importing all the packages whatever needed in class
 * 
 */
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 */
@Entity
public class Supplier {
	/**
	 * @Id - This annotation is placed on a specific field that holds the persistent
	 *     identifying properties. This field is treated as a primary key in
	 *     database.
	 * 
	 *     And also Declaring the variable names with the Datatype of String for
	 *     category data.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String suppName;
	private String suppCity;
	private String suppPhone;

	@ManyToMany(mappedBy = "suppliers")
	private Set<Product> products = new HashSet<>();
	// private List<Product> products=new ArrayList<Product>();
	// private Set<Product> products;

	/**
	 * Generate default constructor
	 */
	public Supplier() {

	}

	public Supplier(long id, String suppName, String suppCity, String suppPhone, Set<Product> products) {
		super();
		this.id = id;
		this.suppName = suppName;
		this.suppCity = suppCity;
		this.suppPhone = suppPhone;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public String getSuppPhone() {
		return suppPhone;
	}

	public void setSuppPhone(String suppPhone) {
		this.suppPhone = suppPhone;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", suppName=" + suppName + ", suppCity=" + suppCity + ", suppPhone=" + suppPhone
				+ "]";
	}

	/**
	 * Generate parameterized constructor with above fields.
	 */

	/**
	 * Generate getters and setters for all above fields.
	 */

	/**
	 * Generate toString method for all above fields.
	 */

}