package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.security.model.Role;
import com.kruhliy.diplom.security.model.User;
import com.kruhliy.diplom.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

// можно удалить, использовалось при разработке
@Controller
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String getRegPage() {
        return "registration";
    }

    @PostMapping
    public String setRegisterPage(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB.isPresent()) {
            return "redirect:/registration";
        }

        user.setRoles(Arrays.stream(Role.values()).collect(Collectors.toSet()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login";
    }
}
