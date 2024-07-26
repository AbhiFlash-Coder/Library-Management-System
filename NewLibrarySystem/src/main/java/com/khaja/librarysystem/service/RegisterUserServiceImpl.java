package com.khaja.librarysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaja.librarysystem.entity.RegisterUser;
import com.khaja.librarysystem.repository.RegisterUserRepository;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	 
	private RegisterUserRepository registeruserRepository;
	
	@Autowired
	public RegisterUserServiceImpl(RegisterUserRepository registeruserRepository) {
        this.registeruserRepository = registeruserRepository;
    }
	
	public RegisterUser save(RegisterUser registeruser) {
		return registeruserRepository.save(registeruser);
	}
	
	public RegisterUser findByRegisterUsername(String username) {
		return registeruserRepository.findByUsername(username);
	}
}
