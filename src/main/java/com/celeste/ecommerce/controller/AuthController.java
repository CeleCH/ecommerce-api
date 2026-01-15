package com.celeste.ecommerce.controller;

import com.celeste.ecommerce.model.User;
import com.celeste.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> data) {
        User user = userRepo.findByEmail(data.get("email")).orElseThrow();

        if (!encoder.matches(data.get("password"), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "LOGIN_OK";
    }
}
