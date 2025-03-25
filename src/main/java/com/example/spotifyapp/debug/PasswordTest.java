package com.example.spotifyapp.debug;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    public static void main(String[] args) {
        String hashedPasswordFromDatabase = "$2a$10$r66FAKou4yJWOWVTHNY8cOJ.Vfi2pNw25LFHtj2Aso1ztLb3F0C1a";

        String rawPassword = "test";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        boolean matches = encoder.matches(rawPassword, hashedPasswordFromDatabase);

        if (matches) {
            System.out.println("Hasło jest poprawne!");
        } else {
            System.out.println("Hasło jest niepoprawne!");
        }
    }
}
