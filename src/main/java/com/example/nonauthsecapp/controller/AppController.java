package com.example.nonauthsecapp.controller;

import com.example.nonauthsecapp.model.User;
import com.example.nonauthsecapp.repo.UserRepo;
import com.example.nonauthsecapp.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final UserRepo userRepo;

    @GetMapping
    public String fp(Model model) {
        model.addAttribute("serverTime", new Date().getTime());
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String time) {
        Optional<User> userOptional = userRepo.findUserByUsername(username);
        if (userOptional.isPresent()) {
            String expectedHash = PasswordUtils.hash(userOptional.get().getPass(), time);
            if (expectedHash.equals(password)) {
                return "finish";
            }
        }
        return "err";
    }
}
