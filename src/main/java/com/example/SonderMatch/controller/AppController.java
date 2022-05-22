package com.example.SonderMatch.controller;

import com.example.SonderMatch.repository.UserRepository;
import com.example.SonderMatch.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AppController {

  @Autowired
  private UserRepository userRepo;

  @GetMapping("/")
  public String viewHomePage(){
    return ("<h1>home</h1>");
  }

  @GetMapping("/user")
  public String user() {
    return ("<h1>user</h1>");
  }

  @GetMapping("/admin")
  public String admin() {
    return ("<h1>admmin</h1>");
  }

  @GetMapping("/success")
  public String success() {
    return ("<h1>successr</h1>");
  }

  @GetMapping("/private")
  public String privateUrl() {
    return ("<h1>private</h1>");
  }

  @PostMapping("/api/auth/signup")
  public String proccessRegister(@RequestBody User user){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    userRepo.save(user);
    return "register_success";
  }
}
