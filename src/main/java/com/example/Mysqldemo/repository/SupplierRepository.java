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
import com.example.Mysqldemo.model.Supplier;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.Query
 * repository finder methods you can specify a MongoDB JSON query string to use
 * instead of having the query derived from the method name.
 * 
 * Ex:Let’s create a repository to interact with Product from the database. In
 * repository package, create SupplierRepository interface that extends
 * MongoRepository.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
	/**
	 * Now we can use MongoRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById() ...
	 * 
	 * And We also define custom methods
	 */
	/* @Query("{suppName : ?0}") */
	@Query( value = "SELECT * FROM supplier s WHERE s.supp_name = :suppName", nativeQuery = true)
	List<Supplier> search(String suppName); 

	public Optional<Supplier> getSupplierById(long id);

	void deleteById(long id);

	Optional<Supplier> findById(long l);
	
	@Query( value = "SELECT * FROM supplier s WHERE s.supp_name = :l", nativeQuery = true)
	Optional<Supplier> findSupplierByName(String l);
	
	@Query( value = "SELECT * FROM product_supplier ps WHERE ps.supplier_id = :l", nativeQuery = true)
	Optional<Supplier> findProductBySupplierId(String l);
	
}






