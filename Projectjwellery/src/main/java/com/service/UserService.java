package com.service;

import java.util.List;
import java.util.Optional;
import com.entity.User;

 

public interface UserService {

    public List<User> getAllAppUsers();	
    public Optional<User> getAppUserById(int userId) ;
    public User createAppUser(User user);
    public User updateAppUser(int userId, User updatedUser) ;
    public boolean deleteAppUser(int userId);

}
