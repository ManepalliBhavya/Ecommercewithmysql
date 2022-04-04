package com.example.Mysqldemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mysqldemo.model.Category;
import com.example.Mysqldemo.repository.CategoryRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 * 
 * @Transactional
 * 
 */

@Service
@Transactional
public class CategoryService {
	/**
	 * Declare the category repository.
	 */
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Generate default constructor
	 */
	public CategoryService() {

	}
	
	/**
	 * Generate parameterized constructor
	 */
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	/**
	 * Create a method to search and find the category by name.
	 */
	public List<Category> listAll(String catName) {
		if (catName != null) {
			return categoryRepository.search(catName); 
		}
		return categoryRepository.findAll();
	}

	/**
	 * Create a method to save the category.
	 */
	public boolean savecategory(Category category) {
		if (category != null) {
			categoryRepository.save(category);

			return true;
		} else {
			return false;
		}

	}

	/**
	 * Create a method to saveall the categories.
	 */
	public Iterable<Category> saveAll(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

	/**
	 * Create a method to delete the category using by id.
	 */
	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

	/**
	 * Create a method to find the category by id.
	 */
	public Optional<Category> findCategory(long l) {
		return categoryRepository.getCategoryById(l);
	}
	
	/**
	 * Create a method to findAll the category.
	 */
	public List<Category> findAllCategory(){
		List<Category> list=new ArrayList<Category>();
		list=categoryRepository.findAll();
		return list;
	}

	/**
	 * Create a method to find the category by name.
	 */	
	public Optional<Category> findCategoryByName(String l) {
		return categoryRepository.findCategoryByName(l);
	}
}