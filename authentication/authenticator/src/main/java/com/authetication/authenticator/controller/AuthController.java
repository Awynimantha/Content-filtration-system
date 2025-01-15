package com.authetication.authenticator.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.authetication.authenticator.model.User;
import com.authetication.authenticator.repository.UserRepository;

@RestController
@RequestMapping(path = "/v1/authUser")
public class AuthController {
  
  private AuthenticationManager authenticationManager;
  private UserRepository userRepository;
  public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository) {
    this.authenticationManager = authenticationManager; 
    this.userRepository = userRepository;
  }  
 
  @PostMapping("/register")
  public User saveUser(@RequestBody User user) {
    userRepository.saveUser(user);
    return user;
  }

  @PostMapping("/login")
  public String loginUser(@RequestBody User user) {
    try{
    Authentication authentication = 
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
      );
    } catch(Exception e) {
      throw new RuntimeException("Ivalide Username and Password");
    }
    return "Login Successful";
  }

}
