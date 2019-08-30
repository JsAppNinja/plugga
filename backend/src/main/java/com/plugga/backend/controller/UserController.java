package com.plugga.backend.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plugga.backend.entity.User;
import com.plugga.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
    
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);
        if (user == null){
            throw new RuntimeException("Could not find user using id: " + userId);
        }
        return user;
    }
    
    @PostMapping("/")
    public User addUser(@RequestBody User user){
        user.setId(0);
        user.setDateCreated(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
        return user;
    }
    
    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        userService.save(user);
        return user;
    }
    
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        User tempUser = userService.findById(userId);
        if (tempUser == null){
            throw new RuntimeException("Could not find user using id: " + userId);
        }
        userService.deleteById(userId);
        return "Deleted user with id: " + userId;
    }
}
