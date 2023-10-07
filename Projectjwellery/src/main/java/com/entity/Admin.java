package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.repository.UserRepository;

@Component
public class Admin implements CommandLineRunner {

	 @Autowired
	    private UserRepository appUserRepository;

	    @Override
	    public void run(String... args) throws Exception {
	        // Check if the admin user exists, if not, create it
	        if (!appUserRepository.existsByUsername("admin")) {
	            User adminUser = new User();
	            adminUser.setUsername("admin");
	            adminUser.setPassword("adminpassword");
	            adminUser.setRole("ADMIN");
	            appUserRepository.save(adminUser);
	        }
	    }
	}