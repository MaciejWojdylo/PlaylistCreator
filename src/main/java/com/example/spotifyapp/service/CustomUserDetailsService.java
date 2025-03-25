package com.example.spotifyapp.service;

import com.example.spotifyapp.model.User;
import com.example.spotifyapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Ładowanie użytkownika: {}", username);

        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.error("Użytkownik {} nie znaleziony", username);
            throw new UsernameNotFoundException("Użytkownik nie znaleziony: " + username);
        }
        System.out.println("ladowanie " + username);
        logger.info("Hasło dla użytkownika {}: {}", username, user.getPassword());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new org.springframework.security.core.authority.SimpleGrantedAuthority(user.getRole()))
        );
    }
}
