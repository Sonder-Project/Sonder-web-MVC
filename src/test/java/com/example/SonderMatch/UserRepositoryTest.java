package com.example.SonderMatch;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.SonderMatch.model.User;
import com.example.SonderMatch.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository repo;

  @Test
  public void testCreateUser() {
    User user = new User();
    user.setEmail("test@gmail.com");
    user.setPassword("testPass");
    user.setFirstName("testFirstName");
    user.setLastName("testLastName");

    User savedUser = (User) repo.save(user);
    User existUser = entityManager.find(User.class, savedUser.getId());

    assertThat(user.getEmail().equals(existUser.getEmail()));


  }
}
