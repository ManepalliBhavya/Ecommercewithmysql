package com.example.Mysqldemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Mysqldemo.model.Category;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.Query
 * repository finder methods you can specify a MongoDB JSON query string to use
 * instead of having the query derived from the method name.
 * 
 * Ex:Let’s create a repository to interact with Product from the database. In
 * repository package, create CategoryRepository interface that extends
 * MongoRepository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	/**
	 * Now we can use MongoRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById() ...
	 * 
	 * And We also define custom methods
	 */
	// List<Category> findByNameContaining(String name);
	/* @Query("{catName : ?0}") */
	@Query( value = "SELECT * FROM category c WHERE c.cat_name = :catName", nativeQuery = true)
	List<Category> search(String catName); 
	
	public Optional<Category> getCategoryById(long l);
	void deleteById(long id);
	
	@Query( value = "SELECT * FROM category c WHERE c.cat_name = :l", nativeQuery = true)
	Optional<Category> findCategoryByName(String l);
	
}