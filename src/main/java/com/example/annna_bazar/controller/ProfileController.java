package com.example.annna_bazar.controller;

import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProfileController {

    private final UserService userService;
    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("user", getUser(getCurrentUser()));
        return "profilepage/profile.html";
    }


    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }

    public User getUser(String email){
        User u = userService.fatchByEmail(email);
        return u;
    }
}
