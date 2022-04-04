package com.example.Mysqldemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @Entity - This is a marker annotation which indicates that this class is an
 *         entity. This annotation must be placed on the class name.
 */
@Entity
public class Product {

	/**
	 * @Id - This annotation is placed on a specific field that holds the persistent
	 *     identifying properties. This field is treated as a primary key in
	 *     database.
	 * 
	 *     And also Declaring the variable names with the Datatype of String for
	 *     product data.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String proName;
	private String proDesc;
	private String price;
	private String fileName;
	private String filePath;
	private String imageName1;
	private String imagePath1;
	private String imageName2;
	private String imagePath2;
	private String imageName3;
	private String imagePath3;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categories;

	@ManyToMany
	@JoinTable(name = "product_supplier", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "supplier_id") })
	private Set<Supplier> suppliers = new HashSet<>();
	// private Set<Supplier> suppliers;
	// private List<Supplier> suppliers = new ArrayList<Supplier>();
	// private Supplier suppliers;

	/**
	 * Generate default constructor
	 */
	public Product() {

	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Product(long id, String proName, String proDesc, String price, String fileName, String filePath,
			String imageName1, String imagePath1, String imageName2, String imagePath2, String imageName3,
			String imagePath3, Category categories, Set<Supplier> suppliers) {
		super();
		this.id = id;
		this.proName = proName;
		this.proDesc = proDesc;
		this.price = price;
		this.fileName = fileName;
		this.filePath = filePath;
		this.imageName1 = imageName1;
		this.imagePath1 = imagePath1;
		this.imageName2 = imageName2;
		this.imagePath2 = imagePath2;
		this.imageName3 = imageName3;
		this.imagePath3 = imagePath3;
		this.categories = categories;
		this.suppliers = suppliers;
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

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getImageName1() {
		return imageName1;
	}

	public void setImageName1(String imageName1) {
		this.imageName1 = imageName1;
	}

	public String getImagePath1() {
		return imagePath1;
	}

	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}

	public String getImageName2() {
		return imageName2;
	}

	public void setImageName2(String imageName2) {
		this.imageName2 = imageName2;
	}

	public String getImagePath2() {
		return imagePath2;
	}

	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}

	public String getImageName3() {
		return imageName3;
	}

	public void setImageName3(String imageName3) {
		this.imageName3 = imageName3;
	}

	public String getImagePath3() {
		return imagePath3;
	}

	public void setImagePath3(String imagePath3) {
		this.imagePath3 = imagePath3;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public Set<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Set<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", proName=" + proName + ", proDesc=" + proDesc + ", price=" + price
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", imageName1=" + imageName1 + ", imagePath1="
				+ imagePath1 + ", imageName2=" + imageName2 + ", imagePath2=" + imagePath2 + ", imageName3="
				+ imageName3 + ", imagePath3=" + imagePath3 + ", categories=" + categories + "]";
	}
}