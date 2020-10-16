package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.RegistrationBook;
import com.kruhliy.diplom.repository.RegistrationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kvvj_rj")
public class RegistrationBookController {

    @Autowired
    private RegistrationBookRepository registrationBookRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<RegistrationBook> regBook = registrationBookRepository.findAll();
        model.addAttribute("tables", regBook);
        return "kvvj_rj";
    }
}
