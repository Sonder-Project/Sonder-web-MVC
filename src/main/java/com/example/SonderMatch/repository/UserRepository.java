package com.example.SonderMatch.repository;

import com.example.SonderMatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// This interface is subtype of JpaRepository which defines common persistence operations (including CRUD)
// and the implementation will be generated at runtime by Spring Data JPA
public interface UserRepository extends JpaRepository<User, Long> {
  public User findByEmail(String email);
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
}
