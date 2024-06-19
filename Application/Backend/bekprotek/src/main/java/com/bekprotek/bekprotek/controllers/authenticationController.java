package com.bekprotek.bekprotek.controllers;

import org.springframework.web.bind.annotation.*;
import com.bekprotek.bekprotek.entities.*;
import com.bekprotek.bekprotek.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class authenticationController {


    @Autowired
    private authenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody authenticationEntity authRequest) {
        authService.registerUser(
                authRequest.getEmail(),
                authRequest.getHashedPassword(),
                authRequest.getFirstName(),
                authRequest.getLastName());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody authenticationEntity authRequest) {
        boolean authenticated = authService.authenticateUser(authRequest.getEmail(), authRequest.getHashedPassword());
        if (authenticated) {
            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }

}