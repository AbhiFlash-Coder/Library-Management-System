package com.khaja.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khaja.librarysystem.entity.RegisterUser;
@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

	
	RegisterUser findByUsername(String username);
}
