package com.authetication.authenticator.controller;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authetication.authenticator.model.User;
import com.authetication.authenticator.repository.JDBCUserRepository;

@RestController
@RequestMapping(path = "${url.user}",produces = "application/json")
//fix
@CrossOrigin
public class UserController{
  public JDBCUserRepository userRepository; 

  public UserController(JDBCUserRepository userRepository) {
    this.userRepository = userRepository; 
  }
  
  @GetMapping()
  public Iterable<User> getUsers() {
    return userRepository.getUsers(); 
  }   
  
  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable("id") Long id) {
    return userRepository.getUserById(id);
  }

  @PostMapping()
  public User saveUser(@RequestBody User user) {
    userRepository.saveUser(user);
    return user;
  }
   
}
