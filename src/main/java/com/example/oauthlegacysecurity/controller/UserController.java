package com.example.oauthlegacysecurity.controller;

import com.example.oauthlegacysecurity.entity.Role;
import com.example.oauthlegacysecurity.entity.User;
import com.example.oauthlegacysecurity.payload.SignupRequest;
import com.example.oauthlegacysecurity.repository.RoleRepository;
import com.example.oauthlegacysecurity.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/all")
    public String getAllUsers(){
        log.info("get all users");
        return "all users";
    }

    @PostMapping("signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest signupRequest){
        User existingUser = userRepository.findByUsername(signupRequest.getUsername()).orElse(null);
        if (existingUser != null){
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body("Email is already taken");
        }

        User user = new User();
        List<Role> roles = roleRepository.findByListOfRoleName(signupRequest.getRole());

        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(roles);
        userRepository.save(user);

        return ResponseEntity.ok("signup");
    }
}
