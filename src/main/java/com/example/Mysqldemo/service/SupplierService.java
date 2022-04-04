package com.example.Mysqldemo.service;

import java.util.ArrayList;
/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mysqldemo.model.Category;
import com.example.Mysqldemo.model.Supplier;
import com.example.Mysqldemo.repository.SupplierRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
@Transactional
public class SupplierService {
	/**
	 * Declare the supplier repository.
	 */
	@Autowired
	private SupplierRepository supplierRepository;

	// Generate parameterless constructor
	public SupplierService() {

	}

	// Generate parameterized constructor
	public SupplierService(SupplierRepository supplierRepository) {

		this.supplierRepository = supplierRepository;
	}

	/**
	 * Create a method to find the supplier by name.
	 */
	public List<Supplier> listAll(String suppName) {
		if (suppName != null) {

			return supplierRepository.search(suppName);
			/* return null; */

		}
		return supplierRepository.findAll();
	}
	/**
	 * Create a method to save the supplier.
	 */
	public boolean saveSupplier(Supplier supplier) {
		if (supplier != null) {
			supplierRepository.save(supplier);

			return true;
		} else {
			return false;
		}

	}
	/**
	 * Create a method to saveall the suppliers.
	 */
	public Iterable<Supplier> saveAll(List<Supplier> suppliers) {
		return supplierRepository.saveAll(suppliers);
	}

	/**
	 * Create a method to delete the supplier by id.
	 */
	public void delete(long id) {
		supplierRepository.deleteById(id);
	}

	/**
	 * Create a method to find the supplier by id.
	 */
	public Optional<Supplier> findSupplier(long l) {
		return supplierRepository.findById(l);
	}

	public List<Supplier> findAllSupplier() {
		List<Supplier> listSupp = new ArrayList<Supplier>();
		listSupp = supplierRepository.findAll();
		return listSupp;
	}

	public Optional<Supplier> findSupplierByName(String l) {
		return supplierRepository.findSupplierByName(l);
	}

	
}