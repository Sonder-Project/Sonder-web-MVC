package com.example.SonderMatch.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// This interface is subtype of JpaRepository which defines common persistence operations (including CRUD)
// and the implementation will be generated at runtime by Spring Data JPA
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("SELECT u FROM User u WHERE u.email = ?1")
  public User findByEmail(String email);
}
