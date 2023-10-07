package com.controller;

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.User;
import com.service.UserService;

 

@RestController
@RequestMapping("/api/appusers")
public class UserController {
    @Autowired
    private UserService userService;

 

    @GetMapping
    public ResponseEntity<List<User>> getAllAppUsers() {
        List<User> appUsers = userService.getAllAppUsers();
        return ResponseEntity.ok(appUsers);
    }

 

    @GetMapping("/{userId}")
    public ResponseEntity<User> getAppUserById(@PathVariable int userId) {
        Optional<User> appUser = userService.getAppUserById(userId);
        if (appUser.isPresent()) {
            return ResponseEntity.ok(appUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @PostMapping("/createCustomer")
    public ResponseEntity<User> createAppUser(@RequestBody User user) {
        User createdUser = userService.createAppUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

 

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateAppUser(@PathVariable int userId, @RequestBody User updatedAppUser) {
        User updated = userService.updateAppUser(userId, updatedAppUser);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable int userId) {
        boolean deleted = userService.deleteAppUser(userId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}