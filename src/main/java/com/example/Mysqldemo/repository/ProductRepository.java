package com.example.Mysqldemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Mysqldemo.model.Product;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.Query
 * repository finder methods you can specify a MongoDB JSON query string to use
 * instead of having the query derived from the method name.
 * 
 * Ex:Let’s create a repository to interact with Product from the database.
 * In repository package, create ProductRepository interface that extends MongoRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	/**
	 * Now we can use MongoRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById() ...
	 */
	/* @Query("{proName : ?0}") */

	@Query( value = "SELECT * FROM product p WHERE p.pro_name = :proName", nativeQuery = true)
	List<Product> search(String proName); 
	void save(Optional<Product> prod);

	/**
	 * We also define custom methods
	 */
	public Optional<Product> getProductById(long id);
	Optional<Product> findById(long l);
	void deleteById(long id);
	
	@Query( value = "SELECT * FROM product p WHERE p.category_id = :id", nativeQuery = true)
	List<Product> productByCategoryId(long id);
	

}







