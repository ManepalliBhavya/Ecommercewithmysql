package com.example.Mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.stereotype.Repository;

import com.example.Mysqldemo.model.User;

/**
 * Spring Boot Repository, add this annotation before the class name.
 *
 * created Java Interface file opened, single query for getting user data by
 * email.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	/*
	 * @Query("SELECT u FROM User u WHERE u.email = :email") public User
	 * getUserByEmail(@Param("email") String email);
	 */
	
	User findByEmail(String email);
}
