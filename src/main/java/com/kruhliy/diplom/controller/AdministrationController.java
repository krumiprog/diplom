package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.security.model.User;
import com.kruhliy.diplom.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kvvj_admin")
public class AdministrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String getForm(Model model) {
        List<User> allUsers = userRepository.findAll();
        model.addAttribute("tables", allUsers);
        return "kvvj_admin";
    }

    @PostMapping
    public String createUser(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB.isPresent()) {
            return "redirect:/kvvj_admin";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/kvvj_admin";
    }

    @PostMapping("/update")
    public String update(User user) {
        if (user.getId() != null) {
            Optional<User> userFromDB = userRepository.findById(user.getId());
            if (userFromDB.isPresent()) {
                userFromDB.get().setRoles(user.getRoles());
                userRepository.save(userFromDB.get());
            }
        }
        return "redirect:/kvvj_admin";
    }

    @PostMapping("/delete")
    public String delete(User user) {
        Optional<User> byId = userRepository.findById(user.getId());
        byId.ifPresent(userRepository::delete);
        return "redirect:/kvvj_admin";
    }
}
