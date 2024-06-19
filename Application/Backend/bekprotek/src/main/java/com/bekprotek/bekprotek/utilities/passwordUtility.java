package com.bekprotek.bekprotek.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class passwordUtility {

    private static final SecureRandom RANDOM = new SecureRandom();

    // Generate a random salt
    public static String generateSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash the password with the salt
    public static String hashPassword(String plainPassword, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] hashedPassword = md.digest(plainPassword.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Verify the password
    public static boolean checkPassword(String plainPassword, String hashedPassword, String salt) throws NoSuchAlgorithmException {
        String hash = hashPassword(plainPassword, salt);
        return hash.equals(hashedPassword);
    }
}
