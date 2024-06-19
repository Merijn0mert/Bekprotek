package com.bekprotek.bekprotek.services;

import com.bekprotek.bekprotek.controllers.*;
import com.bekprotek.bekprotek.repositories.*;
import com.bekprotek.bekprotek.entities.*;
import com.bekprotek.bekprotek.utilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.*;
import java.security.NoSuchAlgorithmException;

@Service
public class authenticationService {

    @Autowired
    private authenticationRepository authenticationrepo;
    private passwordUtility passwordutil;

    @Transactional
    public void registerUser(String email, String plainPassword, String firstName, String lastName) {
        try {
            String salt = passwordutil.generateSalt();
            String hashedPassword = passwordutil.hashPassword(plainPassword, salt);
            authenticationEntity user = new authenticationEntity(email, hashedPassword, salt, firstName, lastName, false);
            authenticationrepo.save(user);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            e.printStackTrace(); // Example: Print the stack trace for debugging
            // Optionally, throw a custom runtime exception or handle it according to your application's logic
            throw new RuntimeException("Error occurred while hashing password: " + e.getMessage());
        }
    }

    public boolean authenticateUser(String email, String plainPassword) {
        try {
            authenticationEntity authentity = authenticationrepo.findByEmail(email);
            return authentity != null && passwordutil.checkPassword(plainPassword, authentity.getHashedPassword(), authentity.getSalt());
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            e.printStackTrace(); // Example: Print the stack trace for debugging
            // Optionally, throw a custom runtime exception or handle it according to your application's logic
            throw new RuntimeException("Error occurred while hashing password: " + e.getMessage());
        }
    }

}