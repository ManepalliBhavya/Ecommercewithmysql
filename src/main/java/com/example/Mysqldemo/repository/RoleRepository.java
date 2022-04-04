package com.example.Mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.stereotype.Repository;

import com.example.Mysqldemo.model.Role;

/**
 * Spring Boot Repository, add this annotation before the class name. created
 * Java Interface file opened, single query for getting role data by role name.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	Role findByRole(String role);

}
