package com.khaja.librarysystem.service;


import org.springframework.stereotype.Service;

import com.khaja.librarysystem.entity.RegisterUser;

@Service
public interface RegisterUserService {
	
	  RegisterUser save(RegisterUser registerUser);
RegisterUser findByRegisterUsername(String username);
}
