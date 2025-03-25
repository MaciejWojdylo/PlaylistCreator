package com.example.spotifyapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/history")
    public String showHistory() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            return "history";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}

