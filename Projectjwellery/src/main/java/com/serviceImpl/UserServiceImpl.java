package com.serviceImpl;

import java.util.List;

import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

 

import com.entity.User;

import com.repository.UserRepository;

import com.service.UserService;

 

@Service

public class UserServiceImpl implements UserService{

 

    @Autowired

    private UserRepository userRepository;

 

    public List<User> getAllAppUsers() {

        return userRepository.findAll();

    }	

 

    public Optional<User> getAppUserById(int userId) {

        return userRepository.findById(userId);

    }

 

    public User createAppUser( User user) {

        return userRepository.save(user);

    }

 

    public User updateAppUser(int userId, User updatedUser) {

        if (!userRepository.existsById(userId)) {

        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AppUser not found");

        }

        updatedUser.setUserId(userId);

        return userRepository.save(updatedUser);

    }

 

    public boolean deleteAppUser(int userId) {

        userRepository.deleteById(userId);
        return true;

    }

}

 