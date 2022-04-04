package com.example.Mysqldemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Entity - This is a marker annotation which indicates that this class is an
 *         entity. This annotation must be placed on the class name.
 */
@Entity
public class Category {
	/**
	 * @Id - This annotation is placed on a specific field that holds the persistent
	 *     identifying properties. This field is treated as a primary key in
	 *     database.
	 * 
	 *     And also Declaring the variable names with their respective Datatypes for
	 *     category data.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String catName;

	/**
	 * Generate default constructor
	 */
	public Category() {

	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Category(long id, String catName) {
		super();
		this.id = id;
		this.catName = catName;
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

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + "]";
	}
}