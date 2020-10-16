package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.BookAccounts;
import com.kruhliy.diplom.repository.BookAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kvvj_ks")
public class BookAccountsController {

    @Autowired
    private BookAccountsRepository bookAccountsRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<BookAccounts> bookAccounts = bookAccountsRepository.findAll();
        model.addAttribute("tables", bookAccounts);
        return "kvvj_ks";
    }


}
