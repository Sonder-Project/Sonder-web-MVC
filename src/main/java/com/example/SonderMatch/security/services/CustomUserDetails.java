package com.example.SonderMatch.security.services;

import com.example.SonderMatch.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


// Spring Security will invoke the methods in this class during the authentication process
public class CustomUserDetails implements UserDetails {
  private User user;

  public CustomUserDetails(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // return Arrays.asList(new SimpleGrantedAuthority("USER"));
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isActive();
  }

  public String getFullname() {
    return user.getFirstName() + " " + user.getLastName();
  }
}
