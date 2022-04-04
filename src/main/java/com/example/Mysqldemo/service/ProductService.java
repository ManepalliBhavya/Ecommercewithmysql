package com.example.Mysqldemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mysqldemo.model.Product;
import com.example.Mysqldemo.repository.ProductRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
@Transactional
public class ProductService {
	/**
	 * Declare the product repository.
	 */
	@Autowired
	private ProductRepository productRepository;

	//Generate parameterless constructor
	public ProductService() {

	}

	//Generate parameterized constructor
	public ProductService(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	/**
	 * Create a method to find the product by name.
	 */
	public List<Product> listAll(String proName) {
		if (proName != null) {
			 return productRepository.search(proName); 
			 /*return null;*/
		}
		return productRepository.findAll();
	}

	/**
	 * Create a method to save the product.
	 */
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

//	/**
//	 * Create a method to saveall the products.
//	 */
//	public Iterable<Product> saveAll(List<Product> products) {
//		return productRepository.saveAll(products);
//	}

	/**
	 * Create a method to delete the product.
	 */
	public void delete(long id) {
		productRepository.deleteById(id);
	}

	/**
	 * Create a method to update the product by id.
	 */
	public Optional<Product> update(long id) {
		return productRepository.getProductById(id);

	}

	/**
	 * Create a method to find the product by id.
	 */
	public Optional<Product> findProduct(long l) {
		return productRepository.findById(l);
	}

	/**
	 * Create a method to save the user
	 */
	public boolean saveUser(Product product) {
		if (product != null) {
			productRepository.save(product);

			return true;
		} else {
			return false;
		}

	}

	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public List<Product> productByCategoryId(long id) {
		return productRepository.productByCategoryId(id);
	}
	
}