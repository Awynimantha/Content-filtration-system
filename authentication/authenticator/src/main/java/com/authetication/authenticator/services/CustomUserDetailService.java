package com.authetication.authenticator.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authetication.authenticator.model.User;
import com.authetication.authenticator.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
  private final UserRepository userRepository; 

  public CustomUserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) 
  throws UsernameNotFoundException {
    User user = userRepository.getUserByName(username);
    if(user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(user.getPassword())
            .roles("justuser")
            .build();

  }


}
