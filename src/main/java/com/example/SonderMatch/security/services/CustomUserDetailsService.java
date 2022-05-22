package com.example.SonderMatch.security.services;

import com.example.SonderMatch.repository.UserRepository;
import com.example.SonderMatch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Tells Spring Security how to look up the user information
@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new CustomUserDetails(user);
  }
}
