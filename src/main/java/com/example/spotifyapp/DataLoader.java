//package com.example.spotifyapp;
//
//import com.example.spotifyapp.model.User;
//import com.example.spotifyapp.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public DataLoader(UserRepository userRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (!userRepository.existsByUsername("test")) {
//            User testUser = new User();
//            testUser.setUsername("test");
//            testUser.setPassword(passwordEncoder.encode("test")); // Haszowanie hasła
//            testUser.setRole("USER");
//            userRepository.save(testUser);
//        }
//    }
//}

